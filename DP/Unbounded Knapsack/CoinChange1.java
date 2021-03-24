/**
 * Max number of ways in which for a given sum s coins can be given
 * 
 */
public class CoinChange1 {
    /**
     * Based on Unbounded Knpsack and CountSubsetProblem =>
     * 
     * CountSubset=> no of ways (addition of all choices made)
     * 
     * Kanpsack => choice at each stage whether to include this coin or not
     * 
     * Unbounded => sum=5 , coins=[1,2,3] => 1,1,1,1,1,1 is a possibility =>
     * repetetion is allowed
     * 
     * Matching wt array => coins, as we need to decrese the sum by coin
     */

    public static void main(String[] args) {
        int sum = 4;
        int[] coins = { 1, 2, 3 }; // 4
        // int sum = 10;
        // int[] coins = { 2, 5, 3, 6 }; // 5
        System.out.println("There are " + solve(coins, sum) + " ways");
    }

    public static int solve(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1; // empty subset
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];

                // unbounded, countsubset we just add as we are looking for no of choices not
                // for actual max values/profit led ny those choise, whenever we wanted actual
                // max values we take max as in case of knapsack(either 01 or unbounded) max
                // profit
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i - 1]];
            }
        }

        return dp[n][sum];
    }
}
