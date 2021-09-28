public class BubbleSorter extends Sorter {
    @Override
    int[] sort(int[] arr) {
        boolean swapsMade = true;
        while(swapsMade) {
            swapsMade = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) { // if first number is larger than second number; swap them
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapsMade = true;
                }
            }
        }
        return arr;
    }
}
