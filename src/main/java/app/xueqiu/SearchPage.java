package app.xueqiu;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author： zhong hu
 * @date： 2020/6/3 下午8:42
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class SearchPage {
    public static AppiumDriver driver;
    private By nameList= By.id("name");
    private By searchCanncle= By.id("action_close");


    public SearchPage(AppiumDriver driver) {
        this.driver=driver;
    }


    public SearchPage search(String keyword){
        try {
            driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys(keyword);
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public List<String> getSearchList(){
        List<String> nameList=new ArrayList<>();
        for(Object element:driver.findElements(this.nameList)){
            nameList.add(((WebElement)element).getText());
        }
        return nameList;
    }

    public Double getPrice(){
        driver.findElement(this.nameList).click();
        return Double.valueOf(driver.findElement(By.id("current_price")).getText());
    }

}
