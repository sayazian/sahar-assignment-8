package com.coderscampus.assignment.utils;

import com.coderscampus.assignment.Assignment8;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class NumberTaskCount implements Callable<Integer[]> {
    Assignment8 assignment;
    AtomicIntegerArray globalExtremes;
    Integer[] taskStats;

    public NumberTaskCount(Assignment8 assignment, AtomicIntegerArray globalExtremes) {
        this.assignment = assignment;
        this.globalExtremes = globalExtremes;
        this.taskStats = new Integer[globalExtremes.get(1) - globalExtremes.get(0) + 1];
        Arrays.fill(this.taskStats, 0);
    }

    @Override
    public Integer[] call() {
        List<Integer> numbers = assignment.getNumbers();
        numbers.forEach(this::increment);
        return taskStats;
    }

    private void increment(int x) {
        taskStats[x - globalExtremes.get(0)]++;
    }
}
