package com.coderscampus.numbers;

import com.coderscampus.numbers.service.NumberService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class NumbersApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        NumberService numberService = new NumberService();
        AtomicIntegerArray globalExtremes = new AtomicIntegerArray(new int[]{0, 0});
        numberService.findMinAndMax(globalExtremes);
        numberService.reportStats(globalExtremes);
    }
}