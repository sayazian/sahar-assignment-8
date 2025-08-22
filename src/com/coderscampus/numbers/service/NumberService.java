package com.coderscampus.numbers.service;

import com.coderscampus.assignment.Assignment8;
import com.coderscampus.numbers.domain.NumberTaskCount;
import com.coderscampus.numbers.domain.NumberTaskMinMax;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class NumberService {
    public void findMinAndMax(AtomicIntegerArray globalExtremes) {
        Future<Integer[]> future;
        Integer[] extremes;
        try (ExecutorService service = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 1000; i++) {
                future = service.submit(new NumberTaskMinMax(new Assignment8()));
                extremes = future.get();
                compareWithGlobals(extremes, globalExtremes);
                System.out.println("Min : " + extremes[0] + " and Max : " + extremes[1]);
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Global Min : " + globalExtremes.get(0) + " and Max : " + globalExtremes.get(1));
    }

    private static void compareWithGlobals(Integer[] extremes, AtomicIntegerArray globalExtremes) {
        if (extremes[0] < globalExtremes.get(0)) {
            globalExtremes.set(0, extremes[0]);
        }
        if (extremes[1] > globalExtremes.get(1)) {
            globalExtremes.set(1, extremes[1]);
        }
    }

    public void reportStats(AtomicIntegerArray globalExtremes) throws ExecutionException, InterruptedException {
        Assignment8 assignment = new Assignment8();
        AtomicIntegerArray stats = new AtomicIntegerArray(new int[globalExtremes.get(1) - globalExtremes.get(0) + 1]);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            Future<Integer[]> future = executorService.submit(new NumberTaskCount(assignment, globalExtremes));
            Integer[] taskStats = future.get();
            for (int j = 0; j < stats.length(); j++) {
                stats.set(j, stats.addAndGet(j, taskStats[j]));
            }
        }
        for (int i = 0; i < stats.length(); i++) {
            System.out.println(i + globalExtremes.get(0) + "= " + stats.get(i));
        }
    }
}
