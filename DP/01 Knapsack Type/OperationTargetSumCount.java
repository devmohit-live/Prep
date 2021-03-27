/**
 * You are allowed to change the sign of array elemets , by performing such
 * operation you have to tell count many such ways are there such that on
 * changing sign we get the sum of array to the goven sum
 */
// can't devide the subset into two parts
// // [7,9,3,8,0,2,4,8,3,9]
// 0
// Output
// 40
// Expected
// 0

// Solution: check wheter subset can be made => (S+sum)%2 == 0 (even can be
// divided only) else return 0 => same logicd is been applied to equal sum

// Inp:
// [1]
// 2
// solution: sum<S => not possible return 0

// [1,0] => actual op = 2 => {1} {0} , {1,0} {}
// code will give =>1
// iterate j from 0 instead of 1, to count for 0's too

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
        // int[] arr = { 1, 1, 2, 3 };
        int[] arr = { 1, 0 };
        int target_sum = 1; // 2
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
