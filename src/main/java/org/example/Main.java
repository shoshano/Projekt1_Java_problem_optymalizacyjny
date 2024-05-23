package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Problem test = new Problem(4, 1, 10, 1);
        Result testR;
        testR = test.Solve(27);
        System.out.println( test.toString());
        System.out.println( testR.toString());
    }
}
