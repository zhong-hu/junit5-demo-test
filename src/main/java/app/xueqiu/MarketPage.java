package app.xueqiu;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * @author： zhong hu
 * @date： 2020/6/4 上午10:23
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class MarketPage {
    public static AppiumDriver driver;
    private By nameList= By.id("name");
    private By searchCanncle= By.id("action_close");

    public MarketPage(AppiumDriver driver){
        this.driver=driver;
    }

    public EditGroupPage goToEditGroupPage(){
        driver.findElement(By.id("edit_group")).click();
        return new EditGroupPage(driver);
    }

    public SearchPage goToSearchPage(){
        driver.findElement(By.id("action_search")).click();
        return new SearchPage(driver);
    }


    public MarketPage  addOptional(){
        driver.findElement(this.nameList).click();
        driver.findElement(By.xpath("//*[@text='股票']")).click();
        driver.findElement(By.xpath("//*[@text='加自选']")).click();
        driver.findElement(this.searchCanncle).click();
        return new MarketPage(driver);
    }


}
