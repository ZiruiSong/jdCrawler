package com.wenshi.test;

import com.wenshi.crawler.JdBuyMaskCrawler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestDao {


    @Resource
    private JdBuyMaskCrawler jdBuyMaskCrawler;

    @Test
    public void testCrawler(){
        jdBuyMaskCrawler.chromeCrawlerRun();
    }

}
