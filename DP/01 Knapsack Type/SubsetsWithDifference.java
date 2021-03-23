import java.util.*;

/**
 * Find the number x such the x= count( pair of two subsets in the given array
 * such that abs(s1-s2) = d )' s1,s2 sum of subset 1 and 2 d= given difference
 */

public class SubsetsWithDifference {
    /**
     * Based on countSubsetSum and SubsetMinDiff(maths)
     */

    // s1+s2=sum_array ------- 1
    // s1-s2=d --------2

    // from 1 an d2 s1 = (d+sum_array)/2

    // so s2 will be s1-d
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3 };
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        int d = 1; // 3
        int s1 = (sum + d) / 2;
        int s2 = s1 - d;
        int ans = solve(arr, s2);
        System.out.printf("Count of pairs of subsets having differene of %d are : %d\n", d, ans);
    }

    public static int solve(int arr[], int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        // sum =0
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];

                else
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
            }
        }
        // Arrays.stream(dp).forEach(e -> System.out.println(Arrays.toString(e)));
        return dp[n][sum];
    }

}
