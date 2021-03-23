/**
 * You are allowed to change the sign of array elemets , by performing such
 * operation you have to tell count many such ways are there such that on
 * changing sign we get the sum of array to the goven sum
 */
public class OperationTargetSumCount {
    /**
     * It is exactly CountSubsetWithGivenDifference here there will be two subsets
     * s1(having all +ve values/signed numbers), s2(-ve signed numbers) each time
     * the elements will move from each subset to another so that targetsum=diff(in
     * previous question)(given)(is maintained)
     * 
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3 };
        int target_sum = 1; // 3
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int s1 = (sum + target_sum) / 2;
        int s2 = s1 - target_sum;
        int ans = countSubsetSum(arr, s2);
        System.out.println(ans);

    }

    public static int countSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j];

                if (arr[i - 1] <= j)
                    dp[i][j] += dp[i - 1][j - arr[i - 1]];

            }
        }

        return dp[n][sum];

    }
}
