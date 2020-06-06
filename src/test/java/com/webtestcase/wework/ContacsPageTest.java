package com.webtestcase.wework;

import org.junit.jupiter.api.*;
import web.page.wework.ContactPage;
import web.page.wework.MainPage;
import org.openqa.selenium.By;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(OrderAnnotation.class)
class ContacsPageTest {
    static MainPage main;
    static ContactPage contactPage;

    @BeforeAll
    public static void initDriver(){
        main=new MainPage();
        contactPage=main.goToContactPage();
    }@AfterAll
    public static void quitDriver(){
        main.quit();
    }

    @BeforeEach
    public  void timeSleep(){
        main.sleep(2);
    }

    @Order(1)
    @Test
    void addMember() {
        String usrname=contactPage.addMember("3","3","18888880001").search("3").getUsername(By.className("member_display_cover_detail_name"));
        contactPage.clearSearchKeword();
        assertEquals("3",usrname);
    }

    @Order(2)
    @Test
    public void importFromFile() {
        //todo:
        contactPage.importFromfileByURL(this.getClass().getResource("/企业微信通讯录批量导入模板.xlsx"));
    }

    @Order(3)
    @Test
    void deleteMember() {
        contactPage.search("3").deleteMember();
        contactPage.clearSearchKeword();
        assertEquals("删除成功",contactPage.getUsername(By.id("js_tips")));
    }


    @Order(4)
    @Test
    public void addParty(){
        contactPage.addParty("测试部");
        assertEquals("新建部门成功",contactPage.getUsername(By.id("js_tips")));
    }

    @Order(6)
    @Test
    public void deleteLevel2Party(){
        contactPage.deleteLevel2Party();
        assertEquals("删除部门成功",contactPage.getUsername(By.id("js_tips")));
    }

    @Order(5)
    @Test
    public void addTag(){
        contactPage.addTag("党委书记");
        contactPage.sleep(3);
        contactPage.addTag("党员");
        assertEquals("创建成功",contactPage.getUsername(By.id("js_tips")));
    }

    @Order(7)
    @Test
    public void deletTagFromDetail(){
        contactPage.search("党委书记");
        contactPage.deletTagFromDetail();
        assertEquals("删除成功",contactPage.getUsername(By.id("js_tips")));
    }

    @Order(8)
    @Test
    public void deleteTagFromTree(){
            contactPage.deleteTagFromTree();
            assertEquals("删除成功",contactPage.getUsername(By.id("js_tips")));
    }

}