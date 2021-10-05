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

    @Test
    void getInsertionTreeSorter() {
        SorterFactory sf = new SorterFactory();
        Sorter s1 = sf.getSorter("InsertionSorter");
        Sorter s2 = sf.getSorter("5");
        InsertionSorter bts = new InsertionSorter();
        assertEquals(bts.getClass(), s1.getClass());
        assertEquals(bts.getClass(), s2.getClass());
    }

    @Test
    void getSelectionTreeSorter() {
        SorterFactory sf = new SorterFactory();
        Sorter s1 = sf.getSorter("SelectionSorter");
        Sorter s2 = sf.getSorter("6");
        SelectionSorter bts = new SelectionSorter();
        assertEquals(bts.getClass(), s1.getClass());
        assertEquals(bts.getClass(), s2.getClass());
    }

    @Test
    void getCollectionsSorter() {
        SorterFactory sf = new SorterFactory();
        Sorter s1 = sf.getSorter("CollectionsSorter");
        Sorter s2 = sf.getSorter("7");
        CollectionsSorter bts = new CollectionsSorter();
        assertEquals(bts.getClass(), s1.getClass());
        assertEquals(bts.getClass(), s2.getClass());
    }

    @Test
    void getArraysSorter() {
        SorterFactory sf = new SorterFactory();
        Sorter s1 = sf.getSorter("ArraysSorter");
        Sorter s2 = sf.getSorter("8");
        ArraysSorter bts = new ArraysSorter();
        assertEquals(bts.getClass(), s1.getClass());
        assertEquals(bts.getClass(), s2.getClass());
    }

    @Test
    void getParallelSorter() {
        SorterFactory sf = new SorterFactory();
        Sorter s1 = sf.getSorter("ParallelSorter");
        Sorter s2 = sf.getSorter("9");
        ParallelSorter bts = new ParallelSorter();
        assertEquals(bts.getClass(), s1.getClass());
        assertEquals(bts.getClass(), s2.getClass());
    }
}