package org.example;

import java.util.*;

public class Problem {
    int nrOfItemTypes;
    int seed;
    int upperLimit;
    int lowerLimit;
    int capacity;
    ArrayList<Item> listOfItems;

    public Problem(int nr, int s){
        this.nrOfItemTypes = nr;
        this.seed = s;
        this.upperLimit = 10;
        this.lowerLimit =1;
        this.listOfItems = randomGenerator();
    }

    public void setListOfItems(ArrayList<Item> list){
        this.listOfItems = list;
    }

    public ArrayList<Item> getListOfItems(){
        return this.listOfItems;
    }

    public ArrayList<Item> randomGenerator() {
        Random rand = new Random();
        ArrayList<Item> list = new ArrayList<Item>();
        rand.setSeed(seed);
        for(int i = 0; i < nrOfItemTypes; i++) {
            int randValue = (rand.nextInt(upperLimit - lowerLimit +1) + lowerLimit);
            int randWeight = (rand.nextInt(upperLimit - lowerLimit +1) + lowerLimit);
            Item temp = new Item(i, randValue, randWeight);
            list.add(temp);
        }
        return list;
    }



    public Result Solve(int capacity){
        ArrayList<Item> listCopy = this.listOfItems;
        ArrayList<Item> resultList = new ArrayList<Item>();

        Collections.sort(listCopy, Comparator.comparing(Item::getRatio));
        Collections.reverse(listCopy);
        int currentCapacity = capacity;
        for(Item item : listCopy){
            while(currentCapacity >= item.weight){
                resultList.add(item);
                currentCapacity = currentCapacity - item.weight;
            }
        }
        Result result = new Result(resultList);
        return result;
    }

    @Override
    public String toString() {
        String list = "";
        for (Item item : listOfItems){
            list += item.toString();
        }
        return list;
    }
}
