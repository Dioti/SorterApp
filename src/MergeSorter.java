public class MergeSorter extends Sorter {
    @Override
    void sort(int[] a) {
        mergeSort(a, a.length);
    }

    public void mergeSort(int[] a, int n) {
        if (a.length < 2) { // sorting is complete when array is broken down into individual elements
            return;
        }

        int mid = n / 2; // can do a.length directly but using 'mid' reduces cpu calculations

        // split array into two halves (divide)
        int[] l = new int[mid];
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        int[] r = new int[n - mid];
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }

        // keep doing that using recursion until all array elements are separated (arr.length==1)
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        // merge the divided arrays (conquer)
        merge(a, l, r, mid, n - mid);
    }

    public void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        // go through each element from left and right arrays
        while (i < left && j < right) {
            // compare elements from left and right array
            if (l[i] < r[j]+1) { // if left val is smaller or equal to right val
                a[k++] = l[i++]; // put left val at the end of the array
            }
            else {
                a[k++] = r[j++]; // put right val at the end of the array
            }
        }

        // go through the remainder of the left array
        while (i < left) {
            a[k++] = l[i++];
        }

        // go through the remainder of the right array
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
