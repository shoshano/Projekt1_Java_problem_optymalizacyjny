package org.example;

import java.util.List;

public class Result {
    List<Item> itemsInKnackpack;
    int totalValue;
    int totalWeight;

    public Result(List<Item> list){
        this.itemsInKnackpack = list;
        totalValue = countValuse();
        totalWeight = countWeight();
    }

    private int countValuse(){
        int value = 0;
        for(Item item : itemsInKnackpack){
            value += item.value;
        }
        return value;
    }

    private int countWeight(){
        int weight = 0;
        for(Item item : itemsInKnackpack){
            weight += item.weight;
        }
        return weight;
    }

    @Override
    public String toString(){
        String list = "";
        for(Item item : itemsInKnackpack){
            list += item.toString();
        }
        list += "Total value: " + this.totalValue + System.lineSeparator();
        list += "Total weight: " + this.totalWeight + System.lineSeparator();
        return list;
    }
}
