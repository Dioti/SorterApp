package com.sparta.java.sorter;

import java.util.Random;

public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        System.out.println("Original array:");
        int[] original = new int[] {9, 8, 7};
        printArray(original);

        for(int element : original) {
            tree.add(element);
        }

        int[] sorted = tree.getInOrder();
        System.out.println("Sorted array:");
        printArray(sorted);
    }

    public static int[] generateRandomIntArray(int min, int max, int len, long seed) {
        Random rand = new Random(seed);
        int[] arr = new int[len];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt((max - min) + 1);
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
            if(i < arr.length - 1) { // no space after last element
                str += " ";
            }
        }
        System.out.println(str);
    }
}
