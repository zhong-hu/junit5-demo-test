package com.apptestcase.xueqiu;

import com.xueqiu.Mainpage;
import com.xueqiu.MarketPage;
import com.xueqiu.SearchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchPageTest {
    static Mainpage mainpage;
    static MarketPage marketPage;
    static SearchPage searchPage;


    @BeforeEach
    void setUp() {
        mainpage=new Mainpage();
        searchPage=mainpage.goToSearchPage();
        marketPage=mainpage.goToMarketPage();
    }

    @AfterEach
    void tearDown() {
        mainpage.quitDriver();
    }

    @Test
    @CsvSource({
            "alibaba,   阿里巴巴",
            "jd,    京东"
    })
    void search(String keyword,String name) {
        assertEquals(searchPage.search(keyword).getSearchList().get(0),name);
    }

    @Test
    void getSearchList() {
    }

    @Test
    void getPrice() {
        assertTrue(searchPage.search("alibaba").getPrice()>200);
    }


}