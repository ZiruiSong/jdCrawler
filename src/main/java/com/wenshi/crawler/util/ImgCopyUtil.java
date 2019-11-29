package com.wenshi.crawler.util;

import java.io.*;

public class ImgCopyUtil {

    public static void copyImg(String path1,String path2){
        File file1=new File(path1);
        File file2=new File(path2);
        byte[] b=new byte[(int)file1.length()];
        FileInputStream in=null;
        FileOutputStream out=null;
        try {
            in=new FileInputStream(file1);
            out=new FileOutputStream(file2);//没有指定文件则会创建
            while(in.read(b)!=-1){    //read()--int，-1表示读取完毕
                out.write(b);
            }
            out.flush();
            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
