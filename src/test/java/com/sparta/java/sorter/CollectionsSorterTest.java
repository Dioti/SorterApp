package com.sparta.java.sorter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollectionsSorterTest {

    @Test
    void getType() {
        assertEquals("Collections Sort", new CollectionsSorter().getType());
    }

    @Test
    void sort() {
        int[] a = new int[] {0,7,9,4,1};
        assertArrayEquals(new int[] {0,1,4,7,9}, new CollectionsSorter().sort(a));
    }

}