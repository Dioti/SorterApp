package com.sparta.java.sorter;

public class SorterFactory {
    public Sorter getSorter(String sorterType) {
        if(sorterType == null) {
            return null;
        }
        switch (sorterType.toUpperCase()) {
            case "1", "BUBBLESORTER": return new BubbleSorter();
            case "2", "MERGESORTER": return new MergeSorter();
            case "3", "QUICKSORTER": return new QuickSorter();
            case "4", "BINARYTREESORTER": return new BinaryTreeSorter();
            case "5", "INSERTIONSORTER": return new InsertionSorter();
            case "6", "SELECTIONSORTER": return new SelectionSorter();
            case "7", "COLLECTIONSSORTER": return new CollectionsSorter();
            case "8", "ARRAYSSORTER": return new ArraysSorter();
            case "9", "PARALLELSORTER": return new ParallelSorter();
            default:
                System.err.println(this.getClass().getSimpleName() + " received an invalid sortType \"" + sorterType + "\"");
                System.exit(0);
        }
        return null;
    }
}
