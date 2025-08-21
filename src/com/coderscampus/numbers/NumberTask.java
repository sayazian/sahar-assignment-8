package com.coderscampus.numbers;

import com.coderscampus.assignment.Assignment8;
import java.util.List;

public class NumberTask implements Runnable {
    Assignment8 assignment;
    public NumberTask(Assignment8 assignment) {
        this.assignment = assignment;
    }
    public void run()  {
        List<Integer> numbers = assignment.getNumbers();

        System.out.println(numbers);
    }
}

