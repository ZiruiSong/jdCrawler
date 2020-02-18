package com.wenshi.crawler.util;


import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 接口请求参数验证
 * @author Administrator
 */
public class ParameterValidator {

	/**
	 * 将接口请求参数封装成map
	 * @param request
	 * @return
	 */
	private static Map<String, String> convertParamsToMap(HttpServletRequest request){
		//使用TreeMap默认对key进行升序排序
		Map<String, String> map = new TreeMap<String, String>();
		//获取所有请求参数名称
        @SuppressWarnings("rawtypes")
        Enumeration paramNames = request.getParameterNames();
        //除签名外其他参数封装成map
        while (paramNames.hasMoreElements()) {  
            String name = (String) paramNames.nextElement();
  
            String value = request.getParameter(name);
            //不对签名算法参数进行排序
            if(!"sign".equals(name)){
            	map.put(name, value); 
            }
        }
        return map;
	}
	/**
	 * 获取排序后的字符串
	 * @param map
	 * @return
	 */
	private static String getSortToString(Map<String, String> map){
		Set<String> keySet = map.keySet();
        Iterator<String> iter = keySet.iterator();
        
        StringBuffer sb = new StringBuffer();
        while (iter.hasNext()) {
            String key = iter.next();
            sb.append(key).append(map.get(key));
        }
		
		return sb.toString();
	}
	/**
	 * 获取http请求参数字符串
	 * @param map
	 * @return
	 */
	public static String getRequestParamsString(Map<String, String> map){
		Set<String> keySet = map.keySet();
        Iterator<String> iter = keySet.iterator();
        
        StringBuffer sb = new StringBuffer();
        while (iter.hasNext()) {
            String key = iter.next();
            sb.append(key).append("=").append(map.get(key)).append("&");
        }
        if(sb.length()>0){
        	sb.deleteCharAt(sb.length()-1);
        }
		
		return sb.toString();
	}
}
