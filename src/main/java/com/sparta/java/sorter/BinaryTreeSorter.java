package com.sparta.java.sorter;

public class BinaryTreeSorter implements Sorter {

    @Override
    public String getType() {
        return "Binary Tree (In Order)";
    }

    @Override
    public int[] sort(int[] a) {
        return new BinaryTree(a).getInOrder();
    }

}
