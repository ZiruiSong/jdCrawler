package com.wenshi.crawler;

import com.wenshi.crawler.config.VisitUrlConfig;
import com.wenshi.crawler.util.BrowserParam;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
@Component("kuruiCrawler")
public class KuruiCrawler {

    private final static String KURUI_LOGIN_URL = "http://vip.ikoori.com/login.zul";

    public void chromeCrawlerRun() {

        //带参数启动Chrome浏览器
        WebDriver driver = new ChromeDriver(BrowserParam.initChrome());
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        //最大化
        driver.navigate().to(KURUI_LOGIN_URL);

    }
}
