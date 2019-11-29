package com.wenshi.crawler.util;

/*
淘宝订单备注格式 ：客服姓名@渠道名称@快递
 */
public class OrderRemarkUtil {
    /*
    客服姓名
     */
    public static String getKefuName(String remark){
        int i=0;
        if(remark.startsWith("@")){
            i=1;
        }
        String[] split = remark.split("@");
        if(split.length>i){
            return split[i];
        }else{
            return "客服没有备注自己的姓名~";
        }
    }

    /*
    渠道名称
     */
    public static String getChannelName(String remark){
        int i=1;
        if(remark.startsWith("@")){
            i=2;
        }
        String[] split = remark.split("@");
        if(split.length>i){
            return split[i];
        }else{
            return "客服没有备注渠道~";
        }
    }

    /*
    快递
     */
    public static String getKuaidi(String remark){
        int i=2;
        if(remark.startsWith("@")){
            i=3;
        }
        String[] split = remark.split("@");
        if(split.length>i){
            return split[i];
        }else{
            return "客服没有备注快递~";
        }
    }
}
