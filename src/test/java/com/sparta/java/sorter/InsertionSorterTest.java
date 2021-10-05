package com.sparta.java.sorter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSorterTest {

    @Test
    void getType() {
        assertEquals("Insertion Sort", new InsertionSorter().getType());
    }

    @Test
    void sort() {
        int[] a = new int[] {0,7,9,4,1};
        assertArrayEquals(new int[] {0,1,4,7,9}, new InsertionSorter().sort(a));
    }

}