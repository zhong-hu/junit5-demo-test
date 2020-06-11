package web.page.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * @author： zhong hu
 * @date： 2020/5/30 下午10:39
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class BasePage {
    public RemoteWebDriver driver;
    public WebDriverWait wait;
    public BasePage(){
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    public BasePage(RemoteWebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void quit(){
        driver.quit();
    }

    public void click(By by){
        //todo:异常处理
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        //等到元素可点击
        wait.until(ExpectedConditions.elementToBeClickable(by));
        this.findElement(by).click();
    }


    public void sendkeys(By by,String content){
        //等到元素可见
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement webElement= this.findElement(by);
        webElement.clear();
        webElement.sendKeys(content);
    }

    public void upload(By by, String path){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        this.findElement(by).sendKeys(path);
    }


    public WebElement findElement(By by){
        WebElement element=driver.findElement(by);
        return element;
    }

    public List<WebElement>  findElements(By by){
        List<WebElement> elements=driver.findElements(by);
        return elements;
    }

    public Boolean isElementExist(By by){
        try {
            this.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
