public class CountSubsetSum {
    /**
     * Count no. of subsets possible for sum =x(given) in the array Base :
     * Subset_sum
     */
    public static void main(String[] args) {
        // int[] arr = { 1, 2, 3, 3 };
        // int sum = 6;
        int n = 96, sum = 185;
        int[] arr = { 6, 10, 1, 4, 7, 1, 9, 5, 10, 5, 3, 5, 10, 1, 5, 4, 4, 3, 8, 10, 10, 7, 4, 1, 6, 7, 6, 6, 8, 3, 4,
                4, 2, 7, 7, 1, 9, 6, 5, 9, 10, 9, 5, 1, 2, 2, 4, 5, 4, 3, 4, 5, 9, 10, 8, 4, 6, 3, 1, 5, 8, 7, 8, 9, 3,
                5, 1, 1, 2, 5, 1, 3, 6, 8, 3, 7, 9, 8, 3, 4, 2, 8, 8, 10, 7, 7, 5, 4, 2, 8, 9, 9, 4, 6, 7, 8 };

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
