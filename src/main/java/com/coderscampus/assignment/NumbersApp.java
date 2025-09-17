package com.coderscampus.assignment;

import com.coderscampus.assignment.service.NumberService;
import com.coderscampus.assignment.service.NumberServiceKevin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicIntegerArray;

//public class NumbersApp {
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        NumberService numberService = new NumberService();
//        AtomicIntegerArray globalExtremes = new AtomicIntegerArray(new int[]{0, 0});
//        numberService.findMinAndMax(globalExtremes);
//        numberService.reportStats(globalExtremes);
//    }
//}


public class NumbersApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        NumberServiceKevin numberServiceKevin = new NumberServiceKevin();
        numberServiceKevin.processNumbers();
        numberServiceKevin.printResults();
        numberServiceKevin.executorServiceShutDown();
    }
}