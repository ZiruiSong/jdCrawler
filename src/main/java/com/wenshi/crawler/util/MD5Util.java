package com.wenshi.crawler.util;

import java.security.MessageDigest;

public class MD5Util {
    private final static String SIGN = "myorder";

    public final static String MD5() {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput = SIGN.getBytes("UTF-8");
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // 将 s 进行 BASE64 编码
    public static String getBASE64(String s) {
        if (s == null) return null;
        return (new sun.misc.BASE64Encoder()).encode( s.getBytes() );
    }

    // 将 BASE64 编码的字符串 s 进行解码
    public static String getFromBASE64(String s) {
        if (s == null) return null;
        sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
        try {
            byte[] b = decoder.decodeBuffer(s);
            return new String(b);
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * 订单系统号码解密
     * @param s
     * @return
     */
    public static String getFromOrders(String s){
        String s1="";
        try {

            EncryptionDecryption des = new EncryptionDecryption(MD5Util.MD5());
            s1 = des.decrypt(s);

            if(s1!=null &&!"".equals(s1.trim())) return s1;
        } catch (Exception e) {


        }

        return  s;
    }
}
