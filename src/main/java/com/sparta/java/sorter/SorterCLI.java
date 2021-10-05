package com.sparta.java.sorter;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SorterCLI {

    // stores a static reference to Logger - avoids multiple instances
    private static Logger logger = Logger.getLogger("SorterApp Logger");

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
                if(length > -1 && length <= Integer.MAX_VALUE) {
                    running = false;
                } else {
                    System.out.println("\nInvalid array size, please enter a positive integer.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Input is invalid! Must be a positive int, less than or equal to " + Integer.MAX_VALUE + ".");
                System.exit(1);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
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
            System.out.println("4.\tBinaryTreeSorter");
            System.out.println("5.\tInsertionSorter");
            System.out.println("6.\tSelectionSorter");
            System.out.println("7.\tCollectionsSorter");
            System.out.println("8.\tArraysSorter");
            System.out.println("9.\tParallelSorter");
            System.out.print("> ");
            try {
                sorterType = in.next();
                switch (sorterType.toUpperCase()) {
                    case "1", "BUBBLESORTER", "2", "MERGESORTER", "3", "QUICKSORTER", "4", "BINARYTREESORTER", "5", "INSERTIONSORTER",
                            "6", "SELECTIONSORTER", "7", "COLLECTIONSSORTER", "8", "ARRAYSSORTER", "9", "PARALLELSORTER" -> running = false;
                    default -> System.out.println("\n" + sorterType + " is not a recognised sort algorithm, please try again.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Input not a string!"); // will probably never happen
                System.exit(1);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        // print original array
        SorterController controller = new SorterController(sorterType, length);
        System.out.println("\nOriginal array:");
        printArray(controller.getArray());

        // do the sort
        long start = System.nanoTime();
        controller.sort();
        long stop = System.nanoTime();

        // print sorted array
        System.out.println("Sorted array: ");
        printArray(controller.getArray());
        String timeTaken = (controller.getSortType() + " : " + (stop - start) + " nanoseconds");

        // by default, uses root of the project
        PropertyConfigurator.configure("log4j.properties");
        logger.info(timeTaken);
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
