import java.io.*;
import java.util.*;

public class SortDates {

    public static void sortDates(String[] arr) {
        countSort(arr, 1000000, 100, 32); // dd
        countSort(arr, 10000, 100, 13); // mm
        countSort(arr, 1, 10000, 2051); // yyyy
    }

    public static void countSort(String[] arr, int div, int mod, int range) {
        int freq[] = new int[range];
        for (int i = 0; i < arr.length; i++) {
            // Integer.parseInt(arr[i], 10) => 02 will be treated as octal so to avoid we
            // explicitly provide base 10
            freq[Integer.parseInt(arr[i], 10) / div % mod]++;
        }
        // prefix
        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }
        // inplace sorting
        String res[] = new String[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = freq[Integer.parseInt(arr[i], 10) / div % mod] - 1;
            res[pos] = arr[i];
            freq[Integer.parseInt(arr[i], 10) / div % mod]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = res[i];
        }

    }

    public static void print(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String str = scn.next();
            arr[i] = str;
        }
        sortDates(arr);
        print(arr);
        scn.close();
    }

}