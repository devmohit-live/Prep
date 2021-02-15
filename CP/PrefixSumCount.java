import java.io.*;

public class PrefixSumCount {

    private static int[] precount(int x, int[] arr) {
        int[] pre = new int[arr.length];
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            c += arr[i] == x ? 1 : 0;
            pre[i] = c;
        }
        // System.out.println("Count vafr: " + c);
        return pre;
    }

    private static int[] presum(int arr[]) {
        int[] pre = new int[arr.length];
        pre[0] = arr[0];

        // different array
        for (int i = 1; i < pre.length; i++) {
            pre[i] += arr[i] + pre[i - 1];
        }

        // same array

        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }
        System.out.println("Same array Sum " + arr[arr.length - 1]);
        return pre;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 2, 2, 2, 1, 5, 3, 5, 1, 2 };
        int[] count = precount(2, arr);
        System.out.println("Count " + (count[arr.length - 1] - count[2]));
        int[] ps = presum(arr);
        System.out.println("Sum " + ps[arr.length - 1]);
    }
}
