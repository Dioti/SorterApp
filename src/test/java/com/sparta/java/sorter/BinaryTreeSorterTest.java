package com.sparta.java.sorter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeSorterTest {

    @Test
    void getType() {
        assertEquals("Binary Tree (In Order)", new BinaryTreeSorter().getType());
    }

    @Test
    void sort() {
        int[] a = new int[] {0,7,9,4,1};
        assertArrayEquals(new int[] {0,1,4,7,9}, new BinaryTreeSorter().sort(a));
    }
}