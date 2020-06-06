package app.xueqiu;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author： zhong hu
 * @date： 2020/6/3 下午8:37
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class Mainpage {
    public static AppiumDriver driver;

    public Mainpage(){
        try {
            DesiredCapabilities caps= new DesiredCapabilities();
            caps.setCapability("platformName","Android");
            caps.setCapability("noReset","true");
            caps.setCapability("uuid","df1b8338");
            caps.setCapability("deviceName","df1b8338");
            caps.setCapability("appPackage","com.xueqiu.android");
            caps.setCapability("appActivity",".view.WelcomeActivityAlias");
            caps.setCapability("unicodeKeyboard","true");
            driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public SearchPage goToSearchPage(){
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        return new SearchPage(driver);
    }

    public MarketPage goToMarketPage(){
        driver.findElement(By.xpath("//*[@text='行情']")).click();
        return new MarketPage(driver);
    }

    public  void quitDriver(){
        driver.quit();
    }

}
