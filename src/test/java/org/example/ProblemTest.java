package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProblemTest {

    @Test
    public void oneCorrectItemCheck(){
        ArrayList<Item> testList = new ArrayList<Item>();
        for (int i = 0; i < 3; i++){
            Item temp = new Item(i, i+2, (i+2)*2);
            testList.add(temp);
        }
        Problem testProblem = new Problem(3, 1);
        testProblem.setListOfItems((ArrayList<Item>)testList);
        Result testResult = testProblem.Solve(4);
        Assertions.assertNotEquals(0, testResult.itemsInKnackpack.size());
    }

    @Test
    public void noCorrectItem(){
        ArrayList<Item> testList = new ArrayList<Item>();
        for (int i = 0; i < 3; i++){
            Item temp = new Item(i, i+2, (i+2)*2);
            testList.add(temp);
        }
        Problem testProblem = new Problem(3, 1);
        testProblem.setListOfItems((ArrayList<Item>)testList);
        Result testResult = testProblem.Solve(3);
        Assertions.assertEquals(0, testResult.itemsInKnackpack.size());
    }

    @Test
    public void valueAndWeightCorrect(){
        Problem testProblem = new Problem(10, 1);

        for(var item : testProblem.getListOfItems()){
            Assertions.assertTrue(item.getValue() <= 10 && item.getValue() >= 1, "Value is from correct range");
            Assertions.assertTrue(item.getWeight() <= 10 && item.getWeight() >= 1, "Weight is from correct range");
        }
    }

    @Test
    public void totakValueAndWeightCorrect(){
        ArrayList<Item> testList = new ArrayList<Item>();

        testList.add(new Item(0, 4, 3));
        testList.add(new Item(0, 4, 3));
        testList.add(new Item(0, 2, 2));
        Result testResult = new Result(testList);
        Assertions.assertAll(
                () -> Assertions.assertEquals(testResult.getTotalValue(), 10),
                () -> Assertions.assertEquals(testResult.getTotalWeight(), 8)
        );
    }
}