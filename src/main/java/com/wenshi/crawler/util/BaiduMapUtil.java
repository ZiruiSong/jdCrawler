package com.wenshi.crawler.util;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BaiduMapUtil {

    //百度地图API基础URL请求地址
    public static final String BASE_URL = "http://api.map.baidu.com/";
    //接口方法名
    public static final String API_METHOD = "geocoder/v2/";
    //输出格式
    public static final String OUTPUT = "json";
    //用户注册申请的key   CRwFQUKdSaj2tUm1u3bc6Ypg2uXR5CeO
    public static final String AK = "CefS9o5GNQzFhOZesop4MypeVRMxofsrX";

    //省
    public static final String PROVINCE = "province";

    //市
    public static final String CITY = "city";

    //区
    public static final String DISTRICT = "district";

    /**
     * 传进一个客户地址，返回对应的行政区划数据
     * @throws IOException
     * @Author ZiruiSong
     * @Time 2018年12月23日
     */
    public static Map<String,String> getAddressComponent(String address) throws IOException {
        Map<String,String> addressComponent = new HashMap<String, String>();
        //先对客户地址进行去噪
        address = removeRubbish(address);
        //1.获取地理坐标
        String url1 = BASE_URL+API_METHOD+"?address="+getSubString(address,84)+"&output="+OUTPUT+"&ak="+AK;//地理编码
        System.out.println(url1);
        String r1 = requestUseGet(url1);
        JSONObject location  = getJSONObjectFromResponseStr(r1,"location");
        Double lat = location.getDouble("lat");//纬度
        Double lng = location.getDouble("lng");//经度
        //2.根据地理坐标获取行政区划数据
        String url2 = BASE_URL+API_METHOD+"?location="+lat+","+lng+"&output="+OUTPUT+"&ak="+AK;//逆地理编码服务
        String r2 = requestUseGet(url2);
        System.out.println(r2);
        JSONObject addressComponentJSONObject = getJSONObjectFromResponseStr(r2,"addressComponent");
        addressComponent.put("country", addressComponentJSONObject.getString("country"));
        addressComponent.put("province", addressComponentJSONObject.getString("province"));
        addressComponent.put("city", addressComponentJSONObject.getString("city"));
        if("绍兴县".equals(addressComponentJSONObject.getString("district")) && address.contains("越城区")){
            addressComponent.put("district", "越城区");
        }else{
            addressComponent.put("district", addressComponentJSONObject.getString("district"));
        }
        addressComponent.put("street", addressComponentJSONObject.getString("street"));
        addressComponent.put("city_level", addressComponentJSONObject.getString("city_level"));
        String formattedAddress = getStringFromResponseStr(r2,"formatted_address");
        addressComponent.put("formatted_address", formattedAddress);
        return addressComponent;
    }

    public static JSONObject getJSONObjectFromResponseStr(String responseStr,String jsonObjectName){
        JSONObject responseJSONObject = JSONObject.parseObject(responseStr);
        String result = responseJSONObject.getString("result");
        JSONObject resultSJONObject = (JSONObject) JSONObject.parse(result);
        JSONObject jsonObject  = resultSJONObject.getJSONObject(jsonObjectName);
        return jsonObject;
    }

    public static String getStringFromResponseStr(String responseStr,String jsonObjectName){
        JSONObject responseJSONObject = JSONObject.parseObject(responseStr);
        String result = responseJSONObject.getString("result");
        JSONObject resultSJONObject = (JSONObject) JSONObject.parse(result);
        String jsonObject  = resultSJONObject.getString(jsonObjectName);
        return jsonObject;
    }

    public static String removeRubbish(String address){
        return address.replace(" ", "").replace("，", "").replace("null", "").replace(",", "").replace("#", "幢").replace("#", "栋").replace("&mdash;", "-");
    }

    public static String requestUseGet(String requestUrl) throws IOException{
        URL url = new URL(requestUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 设置传递方式
        conn.setRequestMethod("GET");
        conn.connect();
        BufferedReader in = null;
        in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
        StringBuilder sb = new StringBuilder();
        String res;
        while((res = in.readLine())!= null){
            sb.append(res);
        }
        return sb.toString();
    }

    /**
     * 根据字节长度截取字符串
     * @Author ZiruiSong
     * @Time 2018年12月23日
     */
    public static String getSubString(String str,int length) throws UnsupportedEncodingException {
        int i,n=0;
        byte[] bytes = str.getBytes("Unicode");
        for(i=2;i<bytes.length&&n<length;i++){
            if(i%2 == 1){
                n++;
            }else{
                if(bytes[i]!=0){
                    n++;
                }
            }
        }

        if(i%2 == 1){
            if(bytes[i-1]!=0){
                i=i-1;
            }else{
                i=i+1;
            }
        }
        return new String(bytes,0,i,"Unicode");
    }
}
