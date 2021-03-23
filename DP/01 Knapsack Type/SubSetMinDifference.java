import java.util.*;

/**
 * Find two subsets of array such that the difference of the sum of both subset
 * is minimum
 */
public class SubSetMinDifference {

    // IDEA:

    // * Sum_array = X can be stated in form of a+b => X=a+b
    // * X= even => max valuw of a,b => a=b=X/2; ex: X=24 a,b=12
    // * X= odd => max valuw of a,b => a=int(X/2), b= a+1; ex: X=15 a=7,b=8
    // the max value of both a and b are the subset sums s1,s2 and in case of both
    // a,b are max possible pair leading to X so their difference will be min.

    // we will find the max value of a possible of s1 as s1 may not necessary gives
    // sum= X/2 or others so we need to get the possible values for s1;
    // this can be obtained using subsetSum problem => create dp[n+1][X/2 +1] and in
    // the last row(dp[n]) look for all true columns => (represents considering all
    // elements of array which sum values are possible) -> iterate from back and
    // return the first true's col(sum)

    // once we find s1, we know s2 can be found (range_max - s1) where ramnge_max
    // =max[0, X]

    // abs(s1-s2) => s1-(range-s1) => 2*s1 - range , so basically we have to
    // minimize abs(2s1-range)

    public static void main(String[] args) {
        int[] arr = { 1, 6, 11, 5 }; // 1
        // int[] arr = { 1, 2, 7 }; // 4
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        int s1 = possibleSubsetSum(arr, sum / 2);

        int ans = Math.abs(2 * s1 - sum);
        System.out.println("Two subset have sum as follow \ns1: " + s1 + "\ns2: " + (sum - s1));
        System.out.println("Minimum difference : " + ans);
    }

    public static int possibleSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j];

                if (arr[i - 1] <= j) {
                    // dp[i][j] |= dp[i - 1][j - arr[i - 1]]; // or
                    dp[i][j] = (dp[i][j] || dp[i - 1][j - arr[i - 1]]);
                }
            }
        }

        for (int i = dp[0].length - 1; i >= 0; i--) {
            if (dp[n][i])
                return i;
        }

        return -1;
    }

}
