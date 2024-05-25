package org.example;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Problem test = new Problem(10, 1);
        Result testR;
        testR = test.Solve(4);
        System.out.println( test.toString());
        System.out.println( testR.toString());
        System.out.println(testR.itemsInKnackpack.size());
    }
}
