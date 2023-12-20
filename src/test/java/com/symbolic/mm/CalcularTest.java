package com.symbolic.mm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalcularTest {

    //TDD
    Caculate calcular = new Caculate();
    @Test
    void testSumEmptyNumber(){
        double result= calcular.sum(0,0);
        assert (result == 0);
    }
    @Test
    void testOneAndOtherZero(){
        int num1 = 10;
        int num2 = 0;
        double result= calcular.sum(num1,num2);
        assert (result == num1);
    }
    @Test
    void testAddTwoNumberNoZero(){
        int num1 = 10;
        int num2 = 2;
        double result= calcular.sum(num1,num2);
        assert (result == 12);
    }
    @Test
    void testAddTwoNumberNegativeNum(){
        int num1 = 10;
        int num2 = - 2;
        double result= calcular.sum(num1,num2);
        assert (result == 8);
    }
    @Test
    void testAddTwoNumberNegativeNum2(){
        int num1 = - 10;
        int num2 = - 2;
        double result= calcular.sum(num1,num2);
        assert (result == -12);
    }

}
