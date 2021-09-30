package com.sparta.java.sorter;

import java.util.Random;

public class SorterController {

    private SorterFactory factory;
    private Sorter model;
    private int[] arr;

    public SorterController(String type, int len) {
        arr = generateRandomIntArray(0, len, len); // TODO: allow user to specify range
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
        model.sort(arr);
    }

    public int[] generateRandomIntArray(int min, int max, int len) {
        Random rand = new Random();
        int[] arr = new int[len];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt((max - min) + 1);
        }
        return arr;
    }

    public void printArray() {
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
            if(i < arr.length - 1) { // no space after last element
                str += " ";
            }
        }
        System.out.println(str);
    }

}
