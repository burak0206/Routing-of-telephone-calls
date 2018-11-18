package com.code.challange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@ComponentScan("com.code.challange")
public class SpringBootConsoleApplication
        implements CommandLineRunner {


    @Autowired
    private CalculateCheapestOperator calculateCheapestOperator;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {

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
        System.out.println(calculateCheapestOperator.getCheapestOperatorForTheNumber("68123456789"));
        System.out.println(calculateCheapestOperator.getCheapestOperatorForTheNumber("4673212345"));
        System.out.println(calculateCheapestOperator.getCheapestOperatorForTheNumber("1111111111"));
        System.out.println(calculateCheapestOperator.getCheapestOperatorForTheNumber("4673212345"));
        System.out.println(calculateCheapestOperator.getCheapestOperatorForTheNumber("4473212345"));

    }
}