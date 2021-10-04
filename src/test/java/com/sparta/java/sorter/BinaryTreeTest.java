package com.sparta.java.sorter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void createEmptyBinaryTree() {
        BinaryTree tree = new BinaryTree();
        assertEquals(null, tree.root);
        assertEquals(0, tree.nodeCount);
    }

    @Test
    void createArrayBinaryTree() {
        BinaryTree tree = new BinaryTree(new int[] {3,7,4,5,8,9,3});
        assertEquals(new BinaryTree(new int[] {3}).root.getClass(), tree.root.getClass());
        assertEquals(7, tree.nodeCount);
    }

    @Test
    void addOne() {
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        assertEquals(1, tree.nodeCount);
    }

    @Test
    void addFive() {
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        assertEquals(5, tree.nodeCount);
    }

    @Test
    void getFiveInOrder() {
        BinaryTree tree = new BinaryTree();
        tree.add(6);
        tree.add(10);
        tree.add(2);
        tree.add(7);
        tree.add(5);
        int[] arr = tree.getInOrder();
        String str = "";
        for(int i = 0; i < arr.length; i++) {
            str += arr[i];
            if(i < arr.length - 1) {
                str += ",";
            }
        }
        assertEquals("2,5,6,7,10", str);
    }
}