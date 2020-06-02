package page.common;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * @author： zhong hu
 * @date： 2020/5/30 下午10:52
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class LoadCookies {
    public Cookie cookie;
    public void setCookie(WebDriver driver ){
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
    }
}
