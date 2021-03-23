public class CountSubsetSum {
    /**
     * Count no. of subsets possible for sum =x(given) in the array Base :
     * Subset_sum
     */
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3 };
        int sum = 6;

        System.out.println(subsetSum(arr, sum));
    }

    public static int subsetSum(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        // sum=0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1; // empty subset
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - arr[i - 1]]);
                    // || is chaged to +
                }
            }
        }
        return dp[n][sum];
    }

}
