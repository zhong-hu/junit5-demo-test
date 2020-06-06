package com.apptestcase.xueqiu;

import com.xueqiu.EditGroupPage;
import com.xueqiu.Mainpage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EditGroupPageTest {
    static Mainpage mainpage;
    static EditGroupPage editGroupPage;

    @BeforeEach
    void setUp() {
        mainpage=new Mainpage();
        editGroupPage=mainpage.goToMarketPage().goToEditGroupPage();
    }

    @AfterEach
    void tearDown() {
        mainpage.quitDriver();
    }


    @Test
    void deleteOptional() {
        editGroupPage.deleteOptional().complete();
    }
}