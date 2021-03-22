import java.util.Arrays;

public class Kanpscak01 {
    // basic recursive approach/code
    static int[][] mem;
    static int dp[][];

    public static int recursive(int[] wt, int[] val, int W, int n) {
        // no cap or no items left
        if (n == 0 || W == 0) {
            return 0;
        }

        if (wt[n - 1] > W) {
            // only 1 option : move with next item
            return recursive(wt, val, W, n - 1);
        } else {
            // 2 choices: add present item val, decrease the cap and move to next item or
            // don't add just move
            return Math.max(val[n - 1] + recursive(wt, val, W - wt[n - 1], n - 1), recursive(wt, val, W, n - 1));
        }
    }

    // using mem
    public static int memoize(int[] wt, int[] val, int W, int n) {
        // no cap or no items left
        if (n == 0 || W == 0) {
            return 0;
        }
        if (mem[n - 1][W] != -1)
            return mem[n - 1][W];

        if (wt[n - 1] > W) {
            // only 1 option : move with next item
            mem[n - 1][W] = recursive(wt, val, W, n - 1);
            return mem[n - 1][W];
        } else {
            // 2 choices: add present item val, decrease the cap and move to next item or
            // don't add just move
            int a = recursive(wt, val, W, n - 1);
            int b = val[n - 1] + recursive(wt, val, W - wt[n - 1], n - 1);
            mem[n - 1][W] = Math.max(a, b);
            return mem[n - 1][W];
        }
    }

    // using tab(top down)

    public static int tabulation(int[] wt, int[] val, int W, int n) {
        // omitting recursive calls

        dp = new int[n + 1][W + 1];
        // basic case of recursion for n
        for (int i = 0; i < dp.length; i++) // <=n
            dp[i][0] = 0;
        // basic case of recursion for w
        for (int i = 0; i < dp[0].length; i++) // <=W
            dp[0][i] = 0;

        // dp[i] => wt,val[i-1] as intially 0th row and col are used for intialization
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // same as memoized here i is n and j is w
                if (wt[i - 1] > j) {
                    // only one option to leave this in this case the profit wouldn't change as this
                    // item havn't contributed
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // max of both the choices
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                    // val[n-1] + wt[n-1] just as memo
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int n = 4;
        int W = 7;
        int[] wt = { 1, 3, 4, 5 };
        int[] val = { 1, 4, 5, 7 };

        mem = new int[4 + 1][7 + 1];
        // filling 2d mem array with -1
        Arrays.stream(mem).forEach(a -> Arrays.fill(a, -1));

        System.out.println("Mem " + memoize(wt, val, W, n));
        System.out.println("Tab: " + tabulation(wt, val, W, n));
    }

}
