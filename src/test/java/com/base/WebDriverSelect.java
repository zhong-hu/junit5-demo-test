package com.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @author： zhong hu
 * @date： 2020/5/29 下午6:06
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class WebDriverSelect {
    public static WebDriver driver;

    @BeforeAll
    public static void initWebDriver(){
        String browserName=System.getenv("browser");
        if("chrome".equals(browserName)){
            System.setProperty("webdriver.chrome.driver","/opt/WebDriver/bin/chromedriver");
            driver=new ChromeDriver();
        }
        else if ("firefox".equals(browserName)){
            System.setProperty("webdriver.gecko.driver","/opt/WebDriver/bin/geckodriver");
            driver=new FirefoxDriver();
        }
        else if ("safari".equals(browserName)){
            driver=new SafariDriver();
        }
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
