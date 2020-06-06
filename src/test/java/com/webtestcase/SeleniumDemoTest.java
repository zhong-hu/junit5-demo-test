package com.webtestcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;




/**
 * @author： zhong hu
 * @date： 2020/5/25 下午6:30
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class SeleniumDemoTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void webDriverInit(){
        //如果未设置环境变量的话，通过System.setProperty来设置webdriver的路径
        //System.setProperty("webdriver.chrome.driver", "/opt/WebDriver/bin/chromedriver");
        driver=new ChromeDriver();
        //隐式等待
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //显示等待
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        //页面加载超时时间设置为 5s
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        //异步脚本的超时时间设置成 3s
        driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void webDriverQuit(){
        driver.quit();
    }

    @Test
    public void windowSizeTest(){
        try {
            driver.get("https://www.baidu.com");
            //窗口最大花
            driver.manage().window().maximize();
            Thread.sleep(3000);
            driver.get("https://m.baidu.com");
            //设置窗口大小
            driver.manage().window().setSize(new Dimension(480,800));
            Thread.sleep(3000);
            //执行浏览器后退
            driver.navigate().back();
            Thread.sleep(3000);
            //执行浏览器前进
            driver.navigate().forward();
            Thread.sleep(3000);
            driver.navigate().refresh();
            //执行浏览器刷新
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void webTest01() {
        try {
            driver.get("https://home.testing-studio.com/");
            driver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
            driver.findElement(By.id("login-account-name")).clear();
            driver.findElement(By.id("login-account-name")).sendKeys("naruto@gmail.com");
            driver.findElement(By.id("login-account-password")).clear();
            driver.findElement(By.id("login-account-password")).sendKeys("naruto@gmail.com");
            driver.findElement(By.id("login-button")).click();
//            强制等待
            Thread.sleep(2000);
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void actionClickTest() {
//        鼠标左键单击、左键双击、右击
        try {
            driver.get("http://sahitest.com/demo/clicks.htm");
            Actions actions = new Actions(driver);
            actions.click(driver.findElement(By.xpath("//input[@value='click me']")));
            actions.doubleClick(driver.findElement(By.xpath("//input[@value='dbl click me']")));
            actions.contextClick(driver.findElement(By.xpath("//input[@value='right click me']")));
            actions.perform();
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void moveToElementTest(){
//        移动鼠标到指定元素上
        try{
            driver.get("https://www.baidu.com");
            Actions actions=new Actions(driver);
            actions.moveToElement(driver.findElement(By.id("s-usersetting-top")));
            actions.perform();
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void dragDropTest(){
//        拖动元素
        try{
            driver.get("http://sahitest.com/demo/dragDropMooTools.htm");
            Actions actions=new Actions(driver);
            actions.dragAndDrop(driver.findElement(By.id("dragger")),driver.findElement(By.xpath("/html/body/div[2]"))).perform();
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void keyBoardTest(){
//        键盘事件
        try {
            driver.get("http://sahitest.com/demo/label.htm");
            Actions actions=new Actions(driver);
            List<WebElement> elements=driver.findElements(By.xpath("//input[@type='textbox']"));
            WebElement element=elements.get(0);
            WebElement element2=elements.get(1);
            element.sendKeys("username");
            actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
            actions.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).perform();
            actions.keyDown(element2,Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();
            element2.clear();
            element.sendKeys(Keys.COMMAND,"a");
            element.sendKeys(Keys.COMMAND,"c");
            element2.sendKeys(Keys.COMMAND,"v");
            Thread.sleep(5000);
        }catch (Exception e){

        }
    }

    @Test
    public void scrollTest(){
        try {
            driver.get("https://www.baidu.com");
            driver.manage().window().maximize();//窗口最大花
            driver.findElement(By.id("kw")).sendKeys("霍格沃滋测试学院");
            driver.findElement(By.id("su")).click();
            Thread.sleep(3000);
            JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id='web.page']/a[last()]"));
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void iframeTest(){
        /**
         * 表单切换
         *
         */
        try {
            driver.get("https://mail.126.com");
            driver.manage().window().maximize();
            WebElement iframe=driver.findElement(By.xpath("//*[@id='loginDiv']/iframe"));
            //切换到表单
            driver.switchTo().frame(iframe);
            driver.findElement(By.xpath("//*[@name='email']")).clear();
            driver.findElement(By.xpath("//*[@name='email']")).sendKeys("seleniumtest@126.com");
            driver.findElement(By.xpath("//*[@name='password']")).clear();
            driver.findElement(By.xpath("//*[@name='password']")).sendKeys("seleniumtest@126.com");
            driver.findElement(By.id("dologin")).click();
            //表单内操作完成后，跳出表单
            driver.switchTo().defaultContent();
            TimeUnit.SECONDS.sleep(2);
            driver.findElement(By.id("lbApp")).click();
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectedTest(){
        try {
            driver.get("https://www.baidu.com");
            Actions actions=new Actions(driver);
            actions.moveToElement(driver.findElement(By.id("s-usersetting-top"))).perform();
            driver.findElement(By.linkText("高级搜索")).click();
            //非Select属性下拉框选择，模拟用户操作来实现
            driver.findElements(By.xpath("//i[@class='c-icon c-select-arrow']")).get(1).click();
            driver.findElements(By.xpath("//*[@data-for='ft']")).get(1).click();
            TimeUnit.SECONDS.sleep(3);
            driver.get("http://sahitest.com/demo/selectTest.htm");
            //Select属性下拉框选择，Select类用于定位select标签。 selectByValue()方法符用于选取<option>标签的value值。
            WebElement element=driver.findElement(By.id("s1"));
            Select sel = new Select(element);
            sel.selectByValue("46");
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void alertTest(){
        try {
            driver.get("https://www.baidu.com");
            driver.findElement(By.id("s-usersetting-top")).click();
            driver.findElement(By.linkText("搜索设置")).click();
            driver.findElement(By.linkText("保存设置")).click();
            //接受（确认）弹框
            TimeUnit.SECONDS.sleep(3);
            driver.switchTo().alert().accept();
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void upLoadFileTest(){
        /**
         * 对于通过input标签实现的上传功能，可以将其看作是一个输入框，即通过sendKeys()指定本地文件路径的方式实现文件上传
         */
        try {
            driver.get("https://www.baidu.com");
            driver.findElement(By.className("soutu-btn")).click();
            //定位上传按钮， 添加本地文件
            driver.findElement(By.className("upload-pic")).sendKeys("/Users/huzhong/IdeaProjects/junit5-demo-test/staticsources/tiger.jpeg");
            TimeUnit.SECONDS.sleep(5);
            //截图保存
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile,new File("staticsources/screenshot.png"));
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
