package com.sparta.java.sorter;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SorterControllerTest {

    @Test
    void getArray() {
        SorterController sc = new SorterController("BubbleSorter", 0);
        int[] a = new int[0];
        assertArrayEquals(a, sc.getArray());
    }

    @Test
    void getBubbleSortType() {
        SorterController sc = new SorterController("BubbleSorter", 1);
        assertEquals("Bubble Sort", sc.getSortType());
    }

    @Test
    void getMergeSortType() {
        SorterController sc = new SorterController("MergeSorter", 1);
        assertEquals("Merge Sort", sc.getSortType());
    }

    @Test
    void getQuickSortType() {
        SorterController sc = new SorterController("QuickSorter", 1);
        assertEquals("Quick Sort", sc.getSortType());
    }

    @Test
    void sortBubble() {
        SorterController sc = new SorterController("BubbleSorter", 10);
        int[] result = sc.getArray();
        int[] expected = result;
        sc.sort();
        Arrays.sort(expected);
        assertArrayEquals(expected, result);
    }

    @Test
    void sortMerge() {
        SorterController sc = new SorterController("MergeSorter", 10);
        int[] result = sc.getArray();
        int[] expected = result;
        sc.sort();
        Arrays.sort(expected);
        assertArrayEquals(expected, result);
    }

    @Test
    void sortQuick() {
        SorterController sc = new SorterController("QuickSorter", 10);
        int[] result = sc.getArray();
        int[] expected = result;
        sc.sort();
        Arrays.sort(expected);
        assertArrayEquals(expected, result);
    }

    @Test
    void generateRandomIntArray() {
        SorterController sc = new SorterController("BubbleSorter", 10, 123);
        int[] result = sc.getArray();
        int[] expected = new int[] {10, 9, 0, 9, 0, 10, 4, 9, 8, 7};
        assertArrayEquals(expected, result);
    }
}