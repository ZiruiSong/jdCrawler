package com.wenshi.crawler.util;

public class GoodsNbrUtil {

    /**
     * 将含有中文等的货号转为标准的货号
     * @param goodsNbrConv
     * @return
     */
    public static String goodsNbrConver(String goodsNbrConv){
        return goodsNbrConv.substring(0, goodsNbrConv.indexOf("/")==-1?goodsNbrConv.length():goodsNbrConv.indexOf("/")).replace("'", "''").replace("-", "").replace(" ", "").replaceAll("[^a-zA-Z0-9]", "");
    }
}
