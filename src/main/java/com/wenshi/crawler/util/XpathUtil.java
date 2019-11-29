package com.wenshi.crawler.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class XpathUtil {
    /*

    订单总价：
    //*[@id="appAmount"]/div/table/tbody/tr/td[2]/div[1]/div[1]/table/tbody/tr/td/span/div/div/span[1]
    //*[@id="appAmount"]/div/table/tbody/tr/td[2]/div[1]/div[1]/table/tbody/tr/td/span/div/div/span[3]
    店铺优惠：
    //*[@id="appAmount"]/div/table/tbody/tr/td[2]/div[1]/div[2]/table/tbody/tr/td/span/div/div/span[1]
    //*[@id="appAmount"]/div/table/tbody/tr/td[2]/div[1]/div[2]/table/tbody/tr/td/span/div/div/span[3]
    运费：
    //*[@id="appAmount"]/div/table/tbody/tr/td[2]/div[1]/div[3]/table/tbody/tr/td/span/div/div/span[1]
    //*[@id="appAmount"]/div/table/tbody/tr/td[2]/div[1]/div[3]/table/tbody/tr/td/span/div/div/span[3]
    订单总价：
    //*[@id="appAmount"]/div/table/tbody/tr/td[2]/div[1]/div[4]/table/tbody/tr/td/span/div/div/span[1]
    //*[@id="appAmount"]/div/table/tbody/tr/td[2]/div[1]/div[4]/table/tbody/tr/td/span/div/div/span[3]
     */

    private static final String TOTAL_DETAIL_PREFIX = "//*[@id=\"appAmount\"]/div/table/tbody/tr/td[2]/div[1]/div[";

    private static final String TOTAL_DETAIL_SUFFIX_1="]/table/tbody/tr/td/span/div/div/span[1]";

    private static final String TOTAL_DETAIL_SUFFIX_3="]/table/tbody/tr/td/span/div/div/span[3]";

    /*
    只适应于淘宝订单，获取订单详情页的商品总价、优惠、运费、应收款等信息
     */
    public static Map<String,String> getTotalCountDetailMap(Integer integer, WebDriver driver){
        Map<String,String> totalCountDetailMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=integer;i++){
            try {
                totalCountDetailMap.put(
                        driver.findElement(By.xpath(TOTAL_DETAIL_PREFIX+i+TOTAL_DETAIL_SUFFIX_1)).getText(),
                        driver.findElement(By.xpath(TOTAL_DETAIL_PREFIX+i+TOTAL_DETAIL_SUFFIX_3)).getText());
            }catch (NoSuchElementException e){
                break;
            }

        }
        return totalCountDetailMap;
    }
}
