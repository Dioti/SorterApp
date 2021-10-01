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
        MergeSorter bs = new MergeSorter();
        assertEquals(bs.getClass(), s1.getClass());
        assertEquals(bs.getClass(), s2.getClass());
    }

    @Test
    void getQuickSorter() {
        SorterFactory sf = new SorterFactory();
        Sorter s1 = sf.getSorter("QuickSorter");
        Sorter s2 = sf.getSorter("3");
        QuickSorter bs = new QuickSorter();
        assertEquals(bs.getClass(), s1.getClass());
        assertEquals(bs.getClass(), s2.getClass());
    }
}