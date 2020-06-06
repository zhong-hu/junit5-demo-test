package com.apptestcase.xueqiu;

import com.xueqiu.Mainpage;
import com.xueqiu.MarketPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MarketPageTest {
    static Mainpage mainpage;
    static MarketPage marketPage;

    @BeforeEach
    void setUp() {
        mainpage=new Mainpage();
        marketPage=mainpage.goToMarketPage();
    }

    @AfterEach
    void tearDown() {
        mainpage.quitDriver();
    }


    @ParameterizedTest
    @CsvSource({
            "jd",
            "alibaba",
            "baiudu"
    })
    void addOptional(String name) {
        marketPage.goToSearchPage().search(name);
        marketPage.addOptional();
    }
}