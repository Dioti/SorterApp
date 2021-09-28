import java.util.Random;
import java.util.Scanner;

public class SorterMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // generate random array
        System.out.print("Generating random int array... how many elements do you want?\n> ");
        int len = in.nextInt();
        int[] arr = generateRandomIntArray(0, len, len); // TODO: allow user to specify range
        printIntArray(arr);

        // create sorter using factory
        System.out.print("\nDo you want to use a BubbleSorter or MergeSorter?\n> ");
        String sorterType = in.next();
        SorterFactory sf = new SorterFactory();
        Sorter s = sf.getSorter(sorterType);

        // do the sorting
        long start, stop;
        start = System.nanoTime();
        int[] sorted = s.sort(arr);
        stop = System.nanoTime();
        printIntArray(sorted);
        System.out.println(sorterType.toUpperCase() + " took " + (stop - start) + " nanoseconds");
    }

    private static int[] generateRandomIntArray(int min, int max, int len) {
        Random rand = new Random();
        int[] arr = new int[len];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt((max - min) + 1);
        }
        return arr;
    }

    private static void printIntArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
