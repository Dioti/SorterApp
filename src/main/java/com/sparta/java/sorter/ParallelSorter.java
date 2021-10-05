package com.sparta.java.sorter;

import java.util.Arrays;

public class ParallelSorter implements Sorter {

    @Override
    public String getType() {
        return "Parallel Sort";
    }

    @Override
    public int[] sort(int[] a) {
        Arrays.parallelSort(a);
        return a;
    }

}
