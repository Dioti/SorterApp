package com.sparta.java.sorter;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SorterControllerTest {

    @Test
    void givenTypeAndLength_CreateController() {
        String type = "BubbleSorter";
        int length = 42;
        SorterController sc = new SorterController(type, length);
        assertEquals("Bubble Sort", sc.getSortType());
        assertEquals(42, sc.getArray().length);
    }

    @Test
    void givenTypeLengthAndSeed_CreateController() {
        String type = "BubbleSorter";
        int length = 42;
        long seed = 123456789;
        SorterController sc = new SorterController(type, length, seed);
        assertEquals("Bubble Sort", sc.getSortType());
        assertEquals(42, sc.getArray().length);
    }

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
    void getBinaryTreeSortType() {
        SorterController sc = new SorterController("BinaryTreeSorter", 1);
        assertEquals("Binary Tree Sort", sc.getSortType());
    }

    @Test
    void getInsertionSortType() {
        SorterController sc = new SorterController("InsertionSorter", 1);
        assertEquals("Insertion Sort", sc.getSortType());
    }

    @Test
    void getSelectionSortType() {
        SorterController sc = new SorterController("SelectionSorter", 1);
        assertEquals("Selection Sort", sc.getSortType());
    }

    @Test
    void getCollectionsSortType() {
        SorterController sc = new SorterController("CollectionsSorter", 1);
        assertEquals("Collections Sort", sc.getSortType());
    }

    @Test
    void getArraysSortType() {
        SorterController sc = new SorterController("ArraysSorter", 1);
        assertEquals("Arrays Sort", sc.getSortType());
    }

    @Test
    void getParallelSortType() {
        SorterController sc = new SorterController("ParallelSorter", 1);
        assertEquals("Parallel Sort", sc.getSortType());
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
    void sortBinaryTree() {
        SorterController sc = new SorterController("BinaryTreeSorter", 10);
        int[] result = sc.getArray();
        int[] expected = result;
        sc.sort();
        Arrays.sort(expected);
        assertArrayEquals(expected, result);
    }

    @Test
    void sortInsertion() {
        SorterController sc = new SorterController("InsertionSorter", 10);
        int[] result = sc.getArray();
        int[] expected = result;
        sc.sort();
        Arrays.sort(expected);
        assertArrayEquals(expected, result);
    }

    @Test
    void sortSelection() {
        SorterController sc = new SorterController("SelectionSorter", 10);
        int[] result = sc.getArray();
        int[] expected = result;
        sc.sort();
        Arrays.sort(expected);
        assertArrayEquals(expected, result);
    }

    @Test
    void sortCollections() {
        SorterController sc = new SorterController("CollectionsSorter", 10);
        int[] result = sc.getArray();
        int[] expected = result;
        sc.sort();
        Arrays.sort(expected);
        assertArrayEquals(expected, result);
    }

    @Test
    void sortArrays() {
        SorterController sc = new SorterController("ArraysSorter", 10);
        int[] result = sc.getArray();
        int[] expected = result;
        sc.sort();
        Arrays.parallelSort(expected);
        assertArrayEquals(expected, result);
    }

    @Test
    void sortParallel() {
        SorterController sc = new SorterController("ParallelSorter", 10);
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