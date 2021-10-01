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
            default:
                System.err.println(this.getClass().getSimpleName() + " received an invalid sortType \"" + sorterType + "\"");
                System.exit(0);
        }
        return null;
    }
}
