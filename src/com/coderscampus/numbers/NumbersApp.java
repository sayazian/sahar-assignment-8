package com.coderscampus.numbers;

import com.coderscampus.assignment.Assignment8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class NumbersApp {
    public static void main(String[] args) {
        Assignment8 assignment = new Assignment8();
        AtomicInteger globalMin = new AtomicInteger(0);
        AtomicInteger globalMax = new AtomicInteger(0);

        try (ExecutorService service = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 5; i++) {
                service.execute(new NumberTask(assignment));
            }
        }
    }
}