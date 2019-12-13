package com.wenshi.crawler.main;

import com.wenshi.crawler.KuruiCrawler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KuruiCrawlerMain {

    public static void main(String[] args) {
        ApplicationContext apc = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.printf("配置文件加载完毕...");
        KuruiCrawler kuruiCrawler = (KuruiCrawler)apc.getBean("kuruiCrawler");
        kuruiCrawler.chromeCrawlerRun();
    }
}
