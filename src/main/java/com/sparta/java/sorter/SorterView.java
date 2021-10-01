package com.sparta.java.sorter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SorterView {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // get user choice for array length
        System.out.println("How many elements do you want?");
        int length = 0;
        boolean running = true;
        while(running) {
            System.out.print("> ");
            try {
                length = in.nextInt();
                if(length > -1) {
                    running = false;
                } else {
                    System.out.println("\nInvalid array size, please enter a positive integer.");
                }
            } catch (InputMismatchException ime) {
                System.err.println("Input not an int!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // get user choice for sort type
        System.out.println("\nWhat sorter do you want to use?");
        String sorterType = null;
        running = true;
        while(running) {
            System.out.println("1.\tBubbleSorter");
            System.out.println("2.\tMergeSorter");
            System.out.println("3.\tQuickSorter");
            System.out.print("> ");
            try {
                sorterType = in.next();
                switch (sorterType.toUpperCase()) {
                    case "1", "BUBBLESORTER", "2", "MERGESORTER", "3", "QUICKSORTER" -> running = false;
                    default -> System.out.println("\n" + sorterType + " is not a recognised sort algorithm, please try again.");
                }
            } catch (InputMismatchException ime) {
                System.err.println("Input not a string!"); // will probably never happen
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // print original array
        SorterController controller = new SorterController(sorterType, length);
        System.out.println("\nOriginal array:");
        controller.printArray();

        // do the sort
        long start = System.nanoTime();
        controller.sort();
        long stop = System.nanoTime();

        // print sorted array
        System.out.println("Sorted array: ");
        controller.printArray();
        System.out.println("[" + controller.getSortType().toUpperCase() + "] Time taken: " + (stop - start) + " nanoseconds");
    }
}
