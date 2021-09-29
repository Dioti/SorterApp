package com.sparta.java.sorter;

public class SorterFactory {
    public Sorter getSorter(String sorterType) {
        if(sorterType == null) {
            return null;
        }
        return switch (sorterType.toUpperCase()) {
            case "1", "BUBBLESORTER" -> new BubbleSorter();
            case "2", "MERGESORTER" -> new MergeSorter();
            case "3", "QUICKSORTER" -> new QuickSorter();
            default -> null;
        };
        // TODO: exception handling for returning null com.sparta.java.sorter.Sorter
    }
}
