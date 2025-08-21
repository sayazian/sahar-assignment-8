package com.coderscampus.numberstest;

import com.coderscampus.assignment.Assignment8;
import com.coderscampus.numbers.NumberTask;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumbersTest {
    // Test-Driven Development Methodology
    // Step 1 - Write a failing test
    // Step 2 - Write the business logic to make the test pass
    // Step 3 - Refactor your code
    @Test
    public void getData() {
        Assignment8 assignment = new Assignment8();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 1000; i++) {
//            List<Integer> numbersList = assignment.getNumbers();
//            System.out.println(numbersList);
//            service.submit(new NumberTask());
        }
    }

}
