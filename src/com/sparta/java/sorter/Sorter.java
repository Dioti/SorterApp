package com.sparta.java.sorter;

interface Sorter {
    void sort(int[] arr) throws NullPointerException;

    String getType();
}
