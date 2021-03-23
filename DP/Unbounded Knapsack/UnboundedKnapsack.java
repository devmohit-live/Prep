import java.util.*;

/** Repetition of items are allowed => infinite supplies of item */
public class UnboundedKnapsack {
    /**
     * Here the scene is suring making decisions if at any point of time you decided
     * not to include that item then that item will be marked as processed and we
     * don't need to mark it any further(as we were doing in 01Knapsack) that we
     * makes call to n-1 in recursion or dp[i-1] in dp
     * 
     * 
     * But in case of item is included, then it will be taken but it will bw not
     * marked as processed until we do so(in case like cap<item[wt] we can't take
     * that item so the only we will mark it processed, otherwise we can have
     * multiple copies of it in the knapack(repetetion)), so recrsively we will cal
     * for n again and in dp[i] again in the case it isn't marked
     */

    public static void main(String[] args) {
        int n = 5;
        int W = 7;
        int[] val = { 1, 3, 4, 4, 5 };
        int[] wt = { 1, 4, 5, 2, 5 };
        tabulation(wt, val, W, n);
        // recursion(wt, val, W, n);
    }

    public static void tabulation(int[] wt, int[] val, int W, int n) {
        int[][] dp = new int[n + 1][W + 1];
        // 0th row and col =0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // not included => marked => call for i-1
                if (wt[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else {// not marked
                      // taken
                    int a = val[i - 1] + dp[i][j - wt[i - 1]];
                    int b = dp[i - 1][j]; // for taking , checking max
                    dp[i][j] = Math.max(a, b);
                }

            }
        }
        System.out.println("Max val is : " + dp[n][W]);
    }

}
