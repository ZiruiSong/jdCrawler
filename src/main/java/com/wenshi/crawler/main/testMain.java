package com.wenshi.crawler.main;

import java.io.File;
import java.io.IOException;

public class testMain {
    public static void main(String[] args) {
        String command = "cmd /C  D:\\download_order\\run.bat";
        try {
            Runtime.getRuntime().exec(command,null,new File("D:\\download_order\\"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
