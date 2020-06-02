package com.testcase;

import com.base.WebDriverSelect;
import org.junit.jupiter.api.Test;

/**
 * @author： zhong hu
 * @date： 2020/5/29 下午6:23
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class BrowserSelectTest extends WebDriverSelect {
    @Test
    public void browserTest(){
        driver.get("https://www.baidu.com");
    }
}
