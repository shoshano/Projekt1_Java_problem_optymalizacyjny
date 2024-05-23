package org.example;

import java.util.*;

public class Problem {
    int nrOfItemTypes;
    int seed;
    int upperLimit;
    int lowerLimit;
    int capacity;
    List<Item> listOfItems;

    public Problem(int nr, int s, int uL, int lL){
        this.nrOfItemTypes = nr;
        this.seed = s;
        this.upperLimit = uL;
        this.lowerLimit =lL;
        this.listOfItems = randomGenerator();
    }

    public List<Item> randomGenerator() {
        Random rand = new Random();
        List<Item> list = new ArrayList<Item>();
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
        List<Item> listCopy = this.listOfItems;
        List<Item> resultList = new ArrayList<Item>();

        Collections.sort(listCopy, Comparator.comparing(Item::getRatio));
        listCopy = listCopy.reversed();
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
