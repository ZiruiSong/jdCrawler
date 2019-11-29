package com.wenshi.crawler.util;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;

public class BrowserParam {
    /*
     * 火狐浏览器初始化参数
     */
    public static FirefoxOptions initFirfox(){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("disable-infobars");
        options.setCapability("excludeSwitches", new String[]{"enable-automation"});
        return options;
    }

    /*
     * 谷歌浏览器初始化参数
     */
    public static ChromeOptions initChrome(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\exe\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        //无头模式
        //options.addArguments("--headless");
        options.addArguments("--start-maximized");
        //全屏
        //options.addArguments("--start-fullscreen");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//        options.setExperimentalOption("prefs",prefs);
        HashMap<String,Integer> prefs = new HashMap<>();
//        prefs.put("profile.managed_default_content_settings.images",2);
//        options.setExperimentalOption("prefs", prefs);
        return options;
    }
}
