import java.util.*;

public class Subset_Sum {
    /**
     * Finding the whether there exists any subset of given array that leads to the
     * given sum
     */
    static boolean dp[][];

    public static void main(String[] args) {
        int[] arr = { 3, 34, 4, 12, 5, 2 };
        // int[] arr = { 2, 3, 11, 8 }; //false

        int sum = 9;
        // int sum = 12;
        System.out.println("Tab : " + tabulation(arr, sum));
    }

    public static boolean tabulation(int[] arr, int sum) {
        dp = new boolean[arr.length + 1][sum + 1];

        // base
        // when length is zero {}(empty array) sum=[1..x] not possible, sum is changing
        // (column)
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = false;
        }
        // when length is changing(row) and sum required is 0 => always possible in
        // empty subset
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        // res same as 01 knapsack

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i - 1] > j) {
                    // not possible to include this item in subset
                    dp[i][j] = dp[i - 1][j]; // take previos ans
                } else {
                    // 2 options
                    // dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]); ->
                    // knapsack
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                    // arr[i-1] represents the sum - arr[i-1] number is required now to make
                    // required sum after including current itme
                }
            }
        }
        // for (boolean[] i : dp) {
        // System.out.println(Arrays.toString(i));
        // }
        return dp[arr.length][sum];

    }

}
