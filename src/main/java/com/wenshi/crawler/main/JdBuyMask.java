package com.wenshi.crawler.main;

import com.wenshi.crawler.JdBuyMaskCrawler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdBuyMask {


    /**
     * 启动前请先开启代理！！！
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext apc = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.printf("配置文件加载完毕...");
        JdBuyMaskCrawler jdBuyMaskCrawler = (JdBuyMaskCrawler)apc.getBean("jdBuyMask");
        jdBuyMaskCrawler.chromeCrawlerRun();
    }
}
