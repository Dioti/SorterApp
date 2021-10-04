package com.sparta.java.sorter;

public class QuickSorter implements Sorter {

    @Override
    public String getType() {
        return "Quick Sort";
    }

    @Override
    public int[] sort(int[] a) {
        quickSort(a, 0, a.length - 1); // use last element in array as pivot
        return a;
    }

    private void quickSort(int[] a, int start, int end) {
        if(start < end) {
            int p_ind = partition(a, start, end);
            quickSort(a, start, p_ind - 1);
            quickSort(a, p_ind + 1, end);
        }
    }

    private int partition(int[] a, int start, int end) {
        int p_ind = end; // use last element in array as pivot
        // TODO: create other ways of choosing a pivot

        for(int i = start; i < end; i++) { // for each element in the current partition
            if (a[i] < a[p_ind]) { // if element value < pivot value
                // then swap that element with the leftmost (first) element
                int temp = a[start];
                a[start] = a[i];
                a[i] = temp;
                start++; // tracks how many elements have been sorted/are on the left
            } // else: do nothing basically, since bigger elements will now be on the right
        }

        // moves pivot from end of array to its proper (partition) index after the sort
        int temp = a[start];
        a[start] = a[p_ind];
        a[end] = temp;

        return start; // return partition index
    }


}
