package com.apptestcase.xueqiu;

import app.xueqiu.MainPage;
import app.xueqiu.MarketPage;
import app.xueqiu.SearchPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchPageTest {
    static MainPage mainpage;
    static MarketPage marketPage;
    static SearchPage searchPage;


    @BeforeAll
    static void setUp() {
        mainpage=new MainPage();
        searchPage=mainpage.goToSearchPage();
    }

    @AfterAll
    static void tearDown() {
        mainpage.quit();
    }

    @DisplayName("搜索")
    @ParameterizedTest
    @CsvSource({
            "alibaba,   阿里巴巴",
            "jd,    京东"
    })
    void search(String keyword,String name) {
        assertEquals(searchPage.search(keyword).getSearchList().get(0),name);
    }


    @DisplayName("获取股票价格")
    @Test
    void getPrice() {
        assertTrue(searchPage.search("alibaba").getPrice()>200);
    }


}