package org.example;

public class Item{
    int index;
    int value;
    int weight;
    double ratio;

    public Item(int id, int v, int w) {
        this.index = id;
        this.value = v;     // <1, 10>
        this.weight = w;    // <1, 10>
        this.ratio = (double) value/weight;
    }

    public double getRatio(){
        return this.ratio;
    }
    @Override
    public String toString() {
        return "No: " + this.index + " value: " + this.value + ",  weight: " + this.weight + ", ratio: " + this.ratio + System.lineSeparator();
    }


}
