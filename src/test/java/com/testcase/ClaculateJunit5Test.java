package com.testcase;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import testclass.Claculate;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @author： zhong hu
 * @date： 2020/5/20 下午3:39
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class ClaculateJunit5Test {

    @ParameterizedTest
    @MethodSource("addTestArguments")
    public void addTest(int expect,int input1,int input2){
        assertEquals(expect,new Claculate().add(input1,input2));
    }

    static Stream<Arguments> addTestArguments() {
        return Stream.of(
                arguments(3, 1, 2),
                arguments(10, 2, 8),
                arguments(7,3,4),
                arguments(6,4,2)
        );
    }

}
