package com.testcase;
import org.junit.jupiter.api.*;

/**
 * @author： zhong hu
 * @date： 2020/5/20 上午11:20
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class Junit5Demo1Test {

    @BeforeAll
    public static void Junit5Demo1TestBeforeClass(){
        System.out.println("Junit5Demo1Test BeforeClass");
    }

    @AfterAll
    public static void Junit5Demo1TestAfterClass(){
        System.out.println("Junit5Demo1Test AfterClass");
    }

    @BeforeEach
    public void Junit5Demo1TestBeforeEach(){
        System.out.println("Junit5Demo1Test BeforeEach");
    }

    @AfterEach
    public void Junit5Demo1TestAfterEach(){
        System.out.println("Junit5Demo1Test AfterEach");
    }


    @DisplayName("测试方法1")
    @RepeatedTest(5)
//    @Test
    void Junit5Demo1TestFun01(){
        System.out.println("Junit5Demo1Test Fun01");
    }

    @Test
    @Disabled
    void Junit5Demo1TestFun02(){
        System.out.println("Junit5Demo1Test Fun02");
    }

}
