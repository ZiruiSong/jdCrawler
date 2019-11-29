package com.wenshi.crawler.util;

public class GoodsSizeUtil {
    //存储固定需要取的尺码
    private static String[] sizeCommonArray = {"XS","S","M","L","XL","XXL","2XL","XXXL","3XL","XXXXL","4XL"};

    /**
     * 转换格式不对的淘宝尺码
     * @param goodsSizeConv
     * @return
     */
    public static String sizeConver(String goodsSizeConv){


        //如果尺码有空格，取前面的
        if(goodsSizeConv != null && goodsSizeConv.contains(" ")) {
            goodsSizeConv = goodsSizeConv.split(" ")[0];
        }
        if(goodsSizeConv != null && goodsSizeConv.contains("(")) {
            goodsSizeConv = goodsSizeConv.split("\\(")[0];
        }
        if(goodsSizeConv != null && goodsSizeConv.contains("（")) {
            goodsSizeConv = goodsSizeConv.split("\\（")[0];
        }

        if(goodsSizeConv != null && goodsSizeConv.contains("/")) {

            String[] ss = goodsSizeConv.split("/");
            //判断是否找到写死的尺码
            boolean isFind = false;
            for (int i = 0; i < ss.length; i++) {
                String size = ss[i].trim();

                for (int j = 0; j < sizeCommonArray.length; j++) {
                    //匹配到尺码 返回对应尺码
                    if(size.equalsIgnoreCase(sizeCommonArray[j])){

                        if(size.equalsIgnoreCase("XXL")){
                            size = "2XL";
                        }
                        if(size.equalsIgnoreCase("XXXL")){
                            size = "3XL";
                        }
                        goodsSizeConv = size;

                        isFind = true;
                        break;
                    }
                }
                if(isFind){
                    break;
                }
            }
            if(!isFind){

                goodsSizeConv = goodsSizeConv.split("/")[0];
            }
        }
        //转换尺码
        if(goodsSizeConv.equalsIgnoreCase("XXL")){
            goodsSizeConv = "2XL";
        }
        if(goodsSizeConv.equalsIgnoreCase("XXXL")){
            goodsSizeConv = "3XL";
        }
        return goodsSizeConv;
    }
}
