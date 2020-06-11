package com.apptestcase.xueqiu;

import app.xueqiu.EditGroupPage;
import app.xueqiu.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EditGroupPageTest {
    static MainPage mainpage;
    static EditGroupPage editGroupPage;

    @BeforeEach
    void setUp() {
        mainpage=new MainPage();
        editGroupPage=mainpage.goToMarketPage().goToEditGroupPage();
    }

    @AfterEach
    void tearDown() {
        mainpage.quit();
    }


    @DisplayName("删除自选")
    @Test
    void deleteOptional() {
        editGroupPage.deleteOptional().complete();
    }
}