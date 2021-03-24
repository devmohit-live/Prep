import java.util.Scanner;

/**
 * Purely Unbounded Knapsack
 * 
 * Variations: 1) Size of rod is given and it can be broken into length of any
 * size between [1 to n] , the corresponding values of the length rod is given
 * flexibitly(in cutting of rod), here the size of rod == to the length array
 * 
 * 2) when there is restriction in cutting of rod example only cut of length
 * 2,3,5 are allowed then n=size of rod != arr.length(3)
 * 
 * ex:
 */

// length | 1 2 3 4 5 6 7 8
// --------------------------------------------
// price | 1 5 8 9 10 17 17 20
// --------------------------------------------
// profit 22 (by cutting in two pieces of lengths 2 and 6)

public class RodCutting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int val[] = new int[n];
        // val[0] -> length =1
        for (int i = 0; i < val.length; i++) {
            val[i] = sc.nextInt();
        }

        System.out.println("Max profit :" + solve(val, n));
    }

    public static int solve(int[] val, int n) {
        int[] length = new int[n];
        for (int i = 0; i < n; i++)
            length[i] = i + 1; // not compulsory just making for comparison sake with unbounbded's wt array

        // there are no resitriction on cuts so here length.length == n
        // for other sinarion length < n
        int[][] dp = new int[n + 1][length.length + 1];

        // 0th row and col =0
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (length[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i][j - length[i - 1]]);
                }
            }
        }
        return dp[n][length.length];
    }

}
