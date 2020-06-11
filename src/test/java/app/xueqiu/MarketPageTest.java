package com.apptestcase.xueqiu;

import app.xueqiu.MainPage;
import app.xueqiu.MarketPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MarketPageTest {
    static MainPage mainpage;
    static MarketPage marketPage;

    @BeforeEach
    void setUp() {
        mainpage=new MainPage();
        marketPage=mainpage.goToMarketPage();
    }

    @AfterEach
    void tearDown() {
        mainpage.quit();
    }

    @DisplayName("添加自选股")
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