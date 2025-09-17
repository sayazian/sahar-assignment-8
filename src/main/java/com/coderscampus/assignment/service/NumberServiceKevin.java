package com.coderscampus.assignment.service;

import com.coderscampus.assignment.Assignment8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class NumberServiceKevin {
    private final Assignment8 assignment8;
    private final Map<Integer, Integer> numberCount;
    private final ExecutorService executorService;

    public NumberServiceKevin() {
        this.assignment8 = new Assignment8();
        this.numberCount = new ConcurrentHashMap<>();
        this.executorService = Executors.newCachedThreadPool();
    }

    public void processNumbers() {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(
                    () -> assignment8.getNumbers().
                            forEach(number -> numberCount.merge(number, 1, Integer::sum)), executorService); //understand

            futures.add(future);
        }
        CompletableFuture.allOf(futures.toArray((new CompletableFuture[0]))).join(); //I don't get this. understand
    }

    public void printResults() {
//        Solution 1 but has a comma at the end.
//        numberCount.forEach((number, count) -> System.out.print((number + "=" + count + ",")));
//        Solution 2
        System.out.println(numberCount.entrySet().stream().map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining(", ")));
    }

    public void executorServiceShutDown() {
        executorService.shutdown();
    }

}
