package com.code.challange;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by burakdagli on 18.11.2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class CalculateCheapestOperatorTest {

    @InjectMocks
    private CalculateCheapestOperator calculateCheapestOperator;

    @Before
    public void init(){
        Map<String, Double> priceListForA = new HashMap<>();
        priceListForA.put("1", 0.9 );
        priceListForA.put("268", 5.1 );
        priceListForA.put("46", 0.17 );
        priceListForA.put("4620", 0.0 );
        priceListForA.put("468", 0.15 );
        priceListForA.put("4631", 0.15 );
        priceListForA.put("4673", 0.9 );
        priceListForA.put("46732", 1.1 );
        Operator A = new Operator("A",priceListForA);

        Map<String, Double> priceListForB = new HashMap<>();
        priceListForB.put("1",0.92);
        priceListForB.put("44",0.5);
        priceListForB.put("46",0.2);
        priceListForB.put("467",1.0);
        priceListForB.put("48",1.2);
        Operator B = new Operator("B",priceListForB);

        calculateCheapestOperator.addOperator(A);
        calculateCheapestOperator.addOperator(B);
    }


    @Test
    public void shouldBeOperatorIsNotFound(){
        assertEquals("Operator is not found for the number: 68123456789",calculateCheapestOperator.getCheapestOperatorForTheNumber("68123456789"));
    }

    @Test
    public void shouldBeOperatorBWithOnePointZero(){
        assertEquals("Operator B : $ 1.0/minute for the number: 4673212345",calculateCheapestOperator.getCheapestOperatorForTheNumber("4673212345"));
    }

    @Test
    public void shouldBeOperatorAWithZeroPointNine(){
        assertEquals("Operator A : $ 0.9/minute for the number: 1111111111",calculateCheapestOperator.getCheapestOperatorForTheNumber("1111111111"));
    }


    @Test
    public void shouldBeOperatorBWithZeroPointFive(){
        assertEquals("Operator B : $ 0.5/minute for the number: 4473212345",calculateCheapestOperator.getCheapestOperatorForTheNumber("4473212345"));
    }




}