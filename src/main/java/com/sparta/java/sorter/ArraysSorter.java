package com.sparta.java.sorter;

import java.util.Arrays;

public class ArraysSorter implements Sorter {

    @Override
    public String getType() {
        return "Arrays Sort";
    }

    @Override
    public int[] sort(int[] a) {
        Arrays.sort(a);
        return a;
    }

}
