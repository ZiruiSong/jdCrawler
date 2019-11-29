package com.wenshi.crawler.main;

import com.wenshi.crawler.OrderCrawler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

public class CrawlerMain {
    /*
    程序主入口
     */
    public static void main(String[] args){
        ApplicationContext apc = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderCrawler orderCrawler = (OrderCrawler) apc.getBean("orderCrawler");
        //JOptionPane.showMessageDialog(null,"1.下载订单前请确保订单备注格式为：@客服姓名@渠道名@快递名\n2.下载速度和网络速度有关请耐心等待\n3.请使用扫码方式登录");
        try {
            orderCrawler.chromeCrawlerRun();
        }catch (Exception e){
            e.printStackTrace();
//            System.exit(0);
            //JOptionPane.showMessageDialog(null,"下载过程出错了~");
        }
//        finally {
////            System.exit(0);
//        }

    }
}
