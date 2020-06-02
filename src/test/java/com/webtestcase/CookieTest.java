package com.webtestcase;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * @author： zhong hu
 * @date： 2020/5/27 下午10:06
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class CookieTest {

    public static WebDriver driver;
    public static Cookie cookie;

    @Test
    public void saveCookiesTest(){
        ChromeOptions option = new ChromeOptions();
        option.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        driver = new ChromeDriver(option);
        driver.get("https://work.weixin.qq.com/wework_admin/frame#index");
        JavascriptExecutor js=(JavascriptExecutor)driver;
//        js.executeScript("window.alert(\"请先扫码登录，以便获取Cookies\");");
        try {
            Thread.sleep(10000);
            FileWriter filewriter=new FileWriter("cookie.txt");
            BufferedWriter bufferedWriter=new BufferedWriter(filewriter);
            for (Cookie cookie:driver.manage().getCookies()){
                bufferedWriter.write(
                        cookie.getName()+";"+
                                cookie.getValue()+";"+
                                cookie.getDomain()+";"+
                                cookie.getPath()+";"+
                                cookie.getExpiry()+";"+
                                cookie.isSecure()
                );
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            filewriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getLocalCookieTest(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://work.weixin.qq.com");
        try {
            FileReader fileReader=new FileReader("cookie.txt");
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                StringTokenizer stringTokenizer=new StringTokenizer(line,";");
                String name=stringTokenizer.nextToken();
                String value=stringTokenizer.nextToken();
                String domian=stringTokenizer.nextToken();
                String path=stringTokenizer.nextToken();
                Date expiry = null;
                String dt=stringTokenizer.nextToken();
                if(null !=dt && !"null".equals(dt)){
                   //Fri Jun 26 23:34:10 CST 2020
                    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss 'CST' yyyy", Locale.ENGLISH);
                    expiry = dateFormat.parse(dt);
                    System.out.println(dt+"\nt"+expiry);
                }
                boolean isSecure=Boolean.parseBoolean(stringTokenizer.nextToken());
                cookie=new Cookie(name,value,domian,path,expiry,isSecure);
                driver.manage().addCookie(cookie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(driver.manage().getCookies());
        driver.get("https://work.weixin.qq.com/wework_admin/frame#index");
        driver.findElements(By.xpath("//span[@class='index_service_cnt_item_title']")).get(1).click();
        try {
            Thread.sleep(5000);
            driver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
