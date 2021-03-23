public class EqualSumSubset {
    /**
     * Print whether the array can be divided into subset (can be of different
     * length) having the equal sum
     * 
     * 
     * Idea here is to check whether the sum of array is evenly divisble into two
     * half or not oif not then making two subsets having equal sum
     * =.(sum_of_array/2) is not possible.
     * 
     * if sum_array is even then, if there exists a subset of sum = sum_array/2 then
     * another subset of same sum would exist
     */
    public static void main(String[] args) {
        // int[] arr = { 2, 3, 11, 8 }; // false
        int[] arr = { 1, 4, 11, 8 }; // true
        long sum = 0;
        for (int i : arr)
            sum += i;

        if ((sum & 1) == 1)
            System.out.println("Not Possible");
        else if (subsetSum(arr, (int) (sum / 2)))
            System.out.println("Partition is possible");
        else
            System.out.println("Not Possible");
    }

    public static boolean subsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        // lenth=0
        for (int i = 0; i < sum + 1; i++) {
            dp[0][i] = false;
        }
        // sum=0
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = (dp[i - 1][j] || dp[i - 1][j - arr[i - 1]]);
                }
            }
        }
        return dp[n][sum];
    }

}
