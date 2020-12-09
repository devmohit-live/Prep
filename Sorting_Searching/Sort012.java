import java.io.*;
import java.util.*;

public class Sort012 {

    public static void sort012Approach1(int[] arr) {
        // using 2 pass
        int pivot = 1;
        int pi = partition(arr, 0, arr.length, pivot);
        pivot = 2;
        int pi2 = partition(arr, pi, arr.length, pivot);

    }

    public static void sort012(int[] arr) {
        int j = 0; // 0 to j-1 => 0's region
        int i = 0; // j+1 to i-1 => 1's area
        // i+1 to k-1 => unknow area
        int k = arr.length - 1; // k+1 to end => 2's area
        while (i <= k) {
            if (arr[i] == 1)
                i++;
            else if (arr[i] == 0) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                swap(arr, i, k);
                k--;
            }
        }
    }

    private static int partition(int arr[], int lo, int high, int pivot) {
        int i = 0, j = 0;
        while (i < high) {
            if (arr[i] >= pivot)
                i++;
            else {
                swap(arr, i, j);
                i++;
                j++;
            }
        }
        return j - 1;
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping index " + i + " and index " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int arr2 = Arrays.copyOf(arr, arr.length);
        sort012Approach1(arr);
        sort012(arr2);
        print(arr);
        System.out.println("Better Approach");
        print(arr2);
    }

}