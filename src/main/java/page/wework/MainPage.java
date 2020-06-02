package page.wework;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import page.common.BasePage;
import page.common.LoadCookies;
import java.util.concurrent.TimeUnit;

/**
 * @author： zhong hu
 * @date： 2020/5/30 下午2:52
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class MainPage extends BasePage {

    public MainPage() {
        super();
        //todo:读取本地cookie
        LoadCookies cookie=new LoadCookies();
        driver.get("https://work.weixin.qq.com");
        cookie.setCookie(driver);
        driver.get("https://work.weixin.qq.com/wework_admin/frame#index");
    }

    public ContactPage  goToContactPage(){
        driver.findElement(By.cssSelector("#menu_contacts")).click();
        return new ContactPage(driver);
    }

    public void quit(){
        driver.quit();
    }
}
