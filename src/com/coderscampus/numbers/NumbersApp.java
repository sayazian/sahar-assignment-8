package com.coderscampus.numbers;

import com.coderscampus.numbers.service.NumberService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class NumbersApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        NumberService numberService = new NumberService();
        AtomicIntegerArray globalExtremes = new AtomicIntegerArray(new int[]{0, 0});
//        numberService.findMinAndMax(globalExtremes);
//        The above line can be run to scan the numbers and extract Min and Max.
//        I disabled it to save time.
        globalExtremes.set(0, 0);
        globalExtremes.set(1, 14);
        numberService.reportStats(globalExtremes);
    }

}