package com.code.challange;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by burakdagli on 18.11.2018.
 */
@Service
public class CalculateCheapestOperator {
    private List<Operator> operators;

    public String getCheapestOperatorForTheNumber(String number){
        Map<String,Double> operatorNameAndPrice = new HashMap<>();
        for (Operator operator : operators) {
            Map<String,Double> priceList = operator.getPriceList();
            String matchedPrefix = "";
            Double cheapestPrice = 0.0;
            for (Map.Entry<String, Double> entry : priceList.entrySet()) {
                String prefix = entry.getKey();
                Double price = entry.getValue();

                if(number.startsWith(prefix) && prefix.length()>matchedPrefix.length()){
                    cheapestPrice = price;
                    matchedPrefix = prefix;
                }
            }
            if(matchedPrefix.length()>0){
                operatorNameAndPrice.put(operator.getOperatorName(),cheapestPrice);
            }
        }

        double minPrice = -1;
        String result = "Operator is not found for the number: "+ number;
        for (Map.Entry<String, Double> entry : operatorNameAndPrice.entrySet()){
            String operatorName = entry.getKey();
            double price = entry.getValue();
            if (minPrice == -1 || price<minPrice){
                minPrice = price;
                result = "Operator "+ operatorName + " : $ " + minPrice +"/minute for the number: "+ number;
            }
        }
        return result;
    }

    public void addOperator(Operator operator) {
        if(!Optional.ofNullable(operators).isPresent()){
            operators = new ArrayList<>();
        }
        operators.add(operator);
    }
}
