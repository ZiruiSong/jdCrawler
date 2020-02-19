package com.wenshi.crawler;

import com.wenshi.crawler.util.BrowserParam;
import com.wenshi.crawler.util.MailUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/*
订单爬虫
 */
@Component("jdBuyMask")
public class JdBuyMaskCrawler {

    private static String JD_URL = "https://passport.jd.com/new/login.aspx";

    private static String[] urlList={
            /*"https://item.jd.com/65426813242.html",
            "https://item.jd.com/65504531652.html",
            "https://item.jd.com/65519834898.html",
            "https://item.jd.com/65519834897.html",
            "https://item.jd.com/57221392023.html",*/
            "https://item.jd.com/65432253973.html"
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
                        System.out.println(new Date()+":"+urlList[i]+"类型口罩无货");
                    }else{
                        webElement.click();
                    }
                }catch (Exception e){
                    System.out.println("暂时无货");
                }

                if(driver.getCurrentUrl().contains("addToCart.html")){
                    driver.findElement(By.xpath("//*[@id=\"GotoShoppingCart\"]")).click();
                    if(driver.getCurrentUrl().contains("cart.action")){//购物车结算
                        MailUtil.sendEmail("有口罩啦","抢到 "+urlList[i]);
                    }
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
