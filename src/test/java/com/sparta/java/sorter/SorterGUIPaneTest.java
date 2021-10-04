package com.sparta.java.sorter;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SorterGUIPaneTest {

    static SorterGUIPane pane;

    @BeforeAll
    static void createPane() {
        pane = new SorterGUIPane();
    }

    @Test
    void givenStringWithSpaces_ReturnIntArray() {
        String str = "1 2 3 4 5 6 7 8 9";
        int[] arr = pane.textToArray(str);
        assertArrayEquals(new int[] {1,2,3,4,5,6,7,8,9}, arr);
    }

    @Test
    void givenStringWithCommas_ReturnIntArray() {
        String str = "1,2,3,4,5,6,7,8,9";
        int[] arr = pane.textToArray(str);
        assertArrayEquals(new int[] {1,2,3,4,5,6,7,8,9}, arr);
    }

    @Test
    void givenStringWithSpacesAndCommas_ReturnIntArray() {
        String str = "1, 2, 3, 4, 5, 6, 7, 8, 9";
        int[] arr = pane.textToArray(str);
        assertArrayEquals(new int[] {1,2,3,4,5,6,7,8,9}, arr);
    }

    @Test
    void arrayToString() {
        int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
        String str = pane.arrayToString(arr);
        assertEquals("1 2 3 4 5 6 7 8 9", str);
    }
}