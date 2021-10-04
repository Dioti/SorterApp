package com.sparta.java.sorter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SorterFactoryTest {

    @Test
    void getBubbleSorter() {
        SorterFactory sf = new SorterFactory();
        Sorter s1 = sf.getSorter("BubbleSorter");
        Sorter s2 = sf.getSorter("1");
        BubbleSorter bs = new BubbleSorter();
        assertEquals(bs.getClass(), s1.getClass());
        assertEquals(bs.getClass(), s2.getClass());
    }

    @Test
    void getMergeSorter() {
        SorterFactory sf = new SorterFactory();
        Sorter s1 = sf.getSorter("MergeSorter");
        Sorter s2 = sf.getSorter("2");
        MergeSorter ms = new MergeSorter();
        assertEquals(ms.getClass(), s1.getClass());
        assertEquals(ms.getClass(), s2.getClass());
    }

    @Test
    void getQuickSorter() {
        SorterFactory sf = new SorterFactory();
        Sorter s1 = sf.getSorter("QuickSorter");
        Sorter s2 = sf.getSorter("3");
        QuickSorter qs = new QuickSorter();
        assertEquals(qs.getClass(), s1.getClass());
        assertEquals(qs.getClass(), s2.getClass());
    }

    @Test
    void getBinaryTreeSorter() {
        SorterFactory sf = new SorterFactory();
        Sorter s1 = sf.getSorter("BinaryTreeSorter");
        Sorter s2 = sf.getSorter("4");
        BinaryTreeSorter bts = new BinaryTreeSorter();
        assertEquals(bts.getClass(), s1.getClass());
        assertEquals(bts.getClass(), s2.getClass());
    }
}