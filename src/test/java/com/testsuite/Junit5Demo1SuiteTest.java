package com.testsuite;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

/**
 * @author： zhong hu
 * @date： 2020/5/23 下午2:33
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("JUnit 5 Suite Demo1")
@SelectPackages("com.testcase")
public class Junit5Demo1SuiteTest {
}
