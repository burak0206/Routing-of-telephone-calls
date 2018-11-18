package com.code.challange;

import java.util.Map;

/**
 * Created by burakdagli on 18.11.2018.
 */
public class Operator {
    private String operatorName;
    private Map<String, Double> priceList;

    public Operator() {
    }

    public Operator(Map<String, Double> priceList) {
        this.priceList = priceList;
    }

    public Operator(String operatorName) {
        this.operatorName = operatorName;
    }

    public Operator(String operatorName, Map<String, Double> priceList) {
        this.operatorName = operatorName;
        this.priceList = priceList;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Map<String, Double> getPriceList() {
        return priceList;
    }

    public void setPriceList(Map<String, Double> priceList) {
        this.priceList = priceList;
    }


}
