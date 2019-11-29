package com.wenshi.crawler.util;

import java.util.regex.Pattern;

public class CustAddrUtil {
    // 例：1234-6978
    public static final String NUMBER_REG = "^-?\\d+(\\-\\d+)?$";

    //例： 222132
    public static final String NUMBER_REG_2 = "^-?\\d+(\\d+)?$";

    /*
     * 返回客户姓名
     */
    public static String findCustName(String address){
        return address.split(",")[0];
    }

    /*
     * 返回收货手机
     */
    public static String findCustTel(String address){
        return address.split(",")[1].replace("86-","");
    }

    /*
     * 返回收货地址
     */
    public static String findCustAddress(String address){

        String ads =  address.split(",")[2];
        Pattern pattern = Pattern.compile(NUMBER_REG);
        if(pattern.matcher(ads).matches()){//全是数字，可能是手机号
            return address.split(",")[3];
        }else{
            return ads;
        }
    }

    /*
     * 返回邮编
     */
    public static String findZip(String address){
        String[] arrs = address.split(",");
        String zip = arrs[3];
        Pattern pattern = Pattern.compile(NUMBER_REG_2);
        if(pattern.matcher(zip).matches()){
            return zip;
        }else{
            if(arrs.length>=4){
                return arrs[4];
            }else{
                return "";
            }
        }
    }
}
