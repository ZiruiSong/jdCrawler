package com.wenshi.crawler;

import com.wenshi.crawler.util.BrowserParam;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/*
订单爬虫
 */
@Component("jdBuyMask")
public class JdBuyMaskCrawler {

    private static String JD_URL = "https://passport.jd.com/new/login.aspx";

    private static String[] urlList={
            "https://item.jd.com/65426813242.html",
            "https://item.jd.com/65504531652.html",
            "https://item.jd.com/65519834898.html",
            "https://item.jd.com/65519834897.html",
            "https://item.jd.com/57221392023.html"
    };
    /*
     * 判断是否登录成功标识
     */

    public void chromeCrawlerRun() {
        //带参数启动Chrome浏览器
        WebDriver driver = new ChromeDriver(BrowserParam.initChrome());
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        //最大化
        driver.navigate().to(JD_URL);

        //手动登录
        while(!driver.getCurrentUrl().contains("https://www.jd.com")){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("系统休眠出错了~");
            }
        }
        while(true){
            for(int i=0;i<urlList.length;i++){

                driver.navigate().to(urlList[i]);
                try {
                    WebElement webElement = driver.findElement(By.xpath("//*[@id=\"InitCartUrl\"]"));
                    if(webElement.getAttribute("class").contains("btn-disable")){
                        System.out.println(urlList[i]+"===========无货");
                    }else{
                        webElement.click();
                    }
                }catch (Exception e){
//                System.out.println("暂时无货");
                }

                if(driver.getCurrentUrl().contains("addToCart.html")){
                    System.out.println(urlList[i]+"===========抢到了！！！");
                    //发送邮件
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
