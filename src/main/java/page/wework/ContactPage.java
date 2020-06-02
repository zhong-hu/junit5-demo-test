package page.wework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.common.BasePage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.time.Duration;

/**
 * @author： zhong hu
 * @date： 2020/5/30 下午2:54
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class ContactPage extends BasePage {

    By deleteMember=By.cssSelector(".js_del_member");
    By addmember=By.cssSelector("a.js_add_member:nth-child(2)");//"添加成员"按钮
    By username=By.id("username");
    By addBtn=By.cssSelector(".member_colLeft_top_addBtnWrap");
    By submit=By.cssSelector(".qui_dialog_foot>a:nth-child(1)");//弹框的确认按钮
    By name=By.cssSelector(".qui_dialog_body input.qui_inputText");//tagName或者partyName
    By group=By.cssSelector("ul.ww_btnGroup > li:nth-child(1) > a");//"组织架构"按钮
    By tag=By.cssSelector("ul.ww_btnGroup>li:nth-child(2)");//"标签"按钮

    public ContactPage(RemoteWebDriver driver) {
        super(driver);
    }

    /**
     * 添加成员
     * @param username：成员姓名
     * @param acctid：成员id
     * @param mobile：成员手机号
     * @return
     */
    public ContactPage addMember(String username,String acctid,String mobile){
        //todo:步骤
        while (findElements(this.username).size()==0){
            click(this.addmember);
        }
        sendkeys(this.username,username);
        sendkeys(By.id("memberAdd_acctid"),acctid);
        sendkeys(By.id("memberAdd_phone"),mobile);
        click(By.cssSelector(".js_btn_save"));
        return this;
    }

    /**
     * 搜索成员、部门、标签
     * @param keyWord：搜索关键字
     * @return
     */
    public ContactPage search(String keyWord){
        sendkeys(By.id("memberSearchInput"),keyWord);
//        MainPage.driver.findElement(By.id("memberSearchInput")).sendKeys(keyWord);
        sleep(1);
        return this;
    }

    /**
     * 删除成员
     * @return
     */
    public ContactPage deleteMember(){
        click(this.deleteMember);
        click(this.submit);
//        driver.findElement(this.delete).click();
//        driver.findElement(By.linkText("确认")).click();
        return this;
    }

    /**
     * 通过文件导入成员
     * @param path：文件在根目录下的相对路径
     * @return
     */
    public ContactPage importFromfile(String path){
        try {
            //获取项目根目录路径
            File directory = new File("");
            String courseFile = directory.getCanonicalPath();
            //根目录拼接文件相对路径后进行URL decode
            String path_utf = URLDecoder.decode(courseFile+path, "UTF-8");
            click(By.cssSelector(".ww_operationBar:nth-child(1) .ww_btn_PartDropdown_left"));
            click(By.linkText("文件导入"));
            upload(By.id("js_upload_file_input"),path_utf);
            click(By.linkText("确认导入"));
            click(By.linkText("前往查看"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     *
     * @param url：文件在resource目录下的相对路径
     * @return
     */
    public ContactPage importFromfileByURL(URL url){
        /**
         * url
         */
        try {
            String path_utf = URLDecoder.decode(url.getFile(), "UTF-8");
            click(By.cssSelector(".ww_operationBar:nth-child(1) .ww_btn_PartDropdown_left"));
            click(By.linkText("文件导入"));
            upload(By.id("js_upload_file_input"),path_utf);
            click(By.linkText("确认导入"));
            click(By.linkText("前往查看"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * 添加部门
     * @param partyName：部门名称
     * @return
     */
    public ContactPage addParty(String partyName){
        click(this.addBtn);
        click(By.className("js_create_party"));
        sendkeys(this.name,partyName);
        click(By.className("js_parent_party_name"));
        click(By.cssSelector(".qui_dialog_body .jstree-anchor"));
        click(this.submit);
        sleep(1);
        return this;
    }

    /**
     * 删除level2部门
     * @return
     */
    public ContactPage deleteLevel2Party(){
        click(this.group);
        click(By.cssSelector("ul ul>li:nth-child(1)"));
        click(By.cssSelector("ul ul>li:nth-child(1) span.icon"));
        click(By.cssSelector("body > ul > li:nth-child(7) > a"));
        click(this.submit);
        sleep(1);
        return this;
    }

    /**
     * 添加标签
     * @param tagName：标签名称
     * @return
     */
    public ContactPage addTag(String tagName){
        click(this.tag);
        sleep(1);
        click(this.addBtn);
        sendkeys(this.name,tagName);
        click(By.cssSelector(".qui_dialog_body a.qui_btn"));
        click(By.cssSelector(".qui_dialog_body div.qui_dropdownMenu li:nth-child(3)>a"));
        click(this.submit);
        sleep(1);
        return this;
    }

    /**
     * 删除标签树下的第一个标签
     * @return
     */
    public ContactPage deleteTagFromTree(){
        click(this.tag);
        click(By.cssSelector("ul.member_tag_list> li:nth-child(1)"));
        click(By.cssSelector("ul.member_tag_list> li:nth-child(1)>a"));
        click(By.cssSelector("ul.vakata-context> li:nth-child(2) >a"));
        click(this.submit);
        sleep(1);
        return this;
    }

    public ContactPage deletTagFromDetail(){
        click(By.linkText("标签详情"));
        click(By.linkText("删除"));
        click(this.submit);
        sleep(1);
        return this;
    }

    public ContactPage clearSearchKeword(){
        click(By.cssSelector(".ww_searchInput_delete"));
        return this;
    }

    public String getUsername(By by){
        return findElement(by).getText();
    }

}

