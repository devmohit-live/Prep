import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/contests/startup-career-fair-challenge/challenges/scf-hard/problem
public class ch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr = new int[t];
        int[] dp = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = sc.nextInt();
        }

        boolean isAsc = isAscending(arr);

        System.out.println(isAsc);

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, longestDecreasingSubsequenceMem(arr, i, dp));
        }
        // if(isAsc) System.out.println(0);
        System.out.println(max);

    }

    private static int longestDecreasingSubsequenceMem(int[] arr, int ei, int[] dp) {
        if (dp[ei] != 0)
            return dp[ei];

        int maxlen = 1; // single number is always a increasing/decreasing subseq
        // this loop will handle the base case itself
        for (int i = ei - 1; i >= 0; i--) {
            if (arr[i] > arr[ei]) { // arr[i] pehle ke elments jo mujhse bde h
                int recans = longestDecreasingSubsequenceMem(arr, i, dp);
                maxlen = Math.max(maxlen, recans + 1);
            }
        }
        return dp[ei] = maxlen;
    }

    static boolean isAscending(int[] arr) {
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (prev >= arr[i])
                return false;
            prev = arr[i];
        }
        return true;
    }

}