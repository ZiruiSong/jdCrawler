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
        try {
            orderCrawler.chromeCrawlerRun();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
