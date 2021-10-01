package com.sparta.java.sorter;

public class BubbleSorter implements Sorter {

    @Override
    public String getType() {
        return "Bubble Sort";
    }

    @Override
    public int[] sort(int[] a) {
        bubbleSort(a);
        return a;
    }

    private void bubbleSort(int[] a) {
        boolean swapsMade = true;
        while(swapsMade) {
            swapsMade = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) { // if first number is larger than second number; swap them
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapsMade = true;
                }
            }
        }
    }
}
