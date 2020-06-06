package app.xueqiu;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

/**
 * @author： zhong hu
 * @date： 2020/6/4 上午10:56
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class EditGroupPage {
    public static AppiumDriver driver;

    public EditGroupPage(AppiumDriver driver){
        this.driver=driver;
    }

    public MarketPage complete(){
        driver.findElement(By.id("action_close"));
        return new MarketPage(driver);
    }

    public EditGroupPage deleteOptional(){
        try {
            driver.findElement(By.id("empty_data_desc"));
        }catch (NoSuchElementException e){
            driver.findElement(By.id("check_all")).click();
            driver.findElement(By.id("cancel_follow")).click();
            driver.findElement(By.id("tv_right")).click();
        }
        return this;
    }


}
