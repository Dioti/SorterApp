package com.sparta.java.sorter;

import java.util.Random;

public class SorterController {

    private SorterFactory factory;
    private Sorter model;
    private int[] arr;

    public SorterController(String type, int[] arr) {
        factory = new SorterFactory();
        model = factory.getSorter(type);
        this.arr = arr;
    }

    public SorterController(String type, int len) {
        arr = generateRandomIntArray(0, len, len, System.currentTimeMillis());
        factory = new SorterFactory();
        model = factory.getSorter(type);
    }

    public SorterController(String type, int len, long seed) {
        arr = generateRandomIntArray(0, len, len, seed);
        factory = new SorterFactory();
        model = factory.getSorter(type);
    }

    public int[] getArray() {
        return arr;
    }

    public String getSortType() {
        return model.getType();
    }

    public void sort() {
        arr = model.sort(arr);
    }

    public void sort(int[] arr) {
        this.arr = model.sort(arr);
    }

    public int[] getSorted(int[] arr) {
        return model.sort(arr);
    }

    // TODO: allow user to specify range
    private int[] generateRandomIntArray(int min, int max, int len, long seed) {
        Random rand = new Random(seed);
        int[] arr = new int[len];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt((max - min) + 1);
        }
        return arr;
    }

}
