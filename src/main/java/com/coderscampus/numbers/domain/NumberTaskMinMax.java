package com.coderscampus.numbers.domain;

import com.coderscampus.assignment.Assignment8;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public class NumberTaskMinMax implements Callable<Integer[]> {
    Assignment8 assignment;
    public NumberTaskMinMax(Assignment8 assignment) {
        this.assignment = assignment;
    }

    @Override
    public Integer[] call() {
        Integer[] extremes = new Integer[2];
        List<Integer> numbers = assignment.getNumbers();
        System.out.println(numbers);
        extremes[0] = Collections.min(numbers);
        extremes[1] = Collections.max(numbers);
        return extremes;
    }
}

