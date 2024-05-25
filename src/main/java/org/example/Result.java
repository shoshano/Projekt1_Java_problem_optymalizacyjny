package org.example;

import java.util.ArrayList;
import java.util.List;

public class Result {
    ArrayList<Item> itemsInKnackpack;
    int totalValue;
    int totalWeight;

    public Result(ArrayList<Item> list){
        this.itemsInKnackpack = list;
        totalValue = countValuse();
        totalWeight = countWeight();
    }

    public int getTotalValue() {
        return totalValue;
    }

    public int getTotalWeight() {
        return totalWeight;
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
