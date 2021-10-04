package com.sparta.java.sorter;

public class BinaryTreeSorter implements Sorter {

    @Override
    public String getType() {
        return "Binary Tree Sort";
    }

    @Override
    public int[] sort(int[] a) {
        return new BinaryTree(a).getInOrder();
    }

}
