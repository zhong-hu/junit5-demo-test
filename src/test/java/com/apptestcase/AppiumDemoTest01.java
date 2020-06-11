package com.apptestcase.appiumTestCase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author： zhong hu
 * @date： 2020/6/2 下午8:22
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class AppiumDemoTest01 {
    public static AppiumDriver driver;
//    public static AndroidDriver<?> driver;

    @BeforeAll
    public static void setup() {
        try {
            DesiredCapabilities caps= new DesiredCapabilities();
            caps.setCapability("platformName","Android");
            caps.setCapability("noReset","true");
            caps.setCapability("uuid","df1b8338");
            caps.setCapability("deviceName","df1b8338");
            caps.setCapability("appPackage","com.xueqiu.android");
            caps.setCapability("appActivity",".view.WelcomeActivityAlias");
            caps.setCapability("unicodeKeyBoard","true");
            driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void xueQiuTest01(){
        //定位首页搜索框
        try {
            driver.findElement(By.xpath("//*[@text='行情']")).click();
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void uiautomatorSelectTest() throws InterruptedException {
        AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) this.driver;
        TimeUnit.SECONDS.sleep(5);
        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.xueqiu.android:id/title_text\").text(\"关注\")").click();
        TimeUnit.SECONDS.sleep(10);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(UiSelector().text(\"雪球路演\").instance(0))").click();
//        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"行情\")").click();
//        new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(UiSelector().text("雪球路演").instance(0));
        TimeUnit.SECONDS.sleep(5);
    }
}




















