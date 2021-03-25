import java.util.*;

/**
 * SPECIAL CASE : here we need to intialize the 1st row too along with 0th row
 * and column as we ned to specify what happens when a prticular coins(single
 * time) is taken should it be included or not (based on sum%coins[i]==0)and
 * what will be the min no of coins in that case.
 */
public class MinCoinsNeeded {
    public static void main(String[] args) {
        // int coins[] = { 25, 10, 5 };
        // int sum = 30;
        int coins[] = { 9, 6, 5, 1 };
        int sum = 11;
        // Output: Minimum 2 coins required

        System.out.println("Min coins needed are " + tabulation(coins, sum));

        // myapproach(coins, sum); // Fails in ceratin conditions
    }

    public static void myapproach(int[] coins, int sum) {
        /***
         * Fails at ceratin cases where minimum no of coins set doen't contains the
         * largest coin
         */
        // Example: sum =11, coins= {9,6,5,1};
        // myapproach will give ans=3 for coins => 9,1,1
        // actual answer is =2 for 6,5

        // time: O(nlogn) to sort coins (no need if already given in some sorted
        // manner)+O(n) to find the coins => nlogn
        // space: O(1)
        Arrays.sort(coins);
        System.out.println(Arrays.toString(coins));
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = coins.length - 1; i >= 0; i--) { // O(n/k)
            while (sum >= coins[i]) { // O(k)
                sum -= coins[i];
                sb.append(coins[i] + " ");
                count++;
            }
        }
        System.out.println("Using arrays concept " + count);
        System.out.println("Coins are " + sb.toString());
    }

    public static int tabulation(int[] coins, int sum) {
        int n = coins.length;
        int[][] dp = new int[n + 1][sum + 1];

        // Intialization:

        // 0th row: sum is varying and we have no coins , then how many coins are
        // required => no answer => fill Integer.MAX_VALUE

        // Why Integer.Max -1 instead of just Integer.max => we are doing dp[i][j]+1 so
        // that can lead to overflow

        for (int i = 0; i < dp[0].length; i++)
            dp[0][i] = Integer.MAX_VALUE - 1;

        // 0th col: sum is 0 and we have x coins x[nothing... all coins] for no coins it
        // is Integer.MAX for others it is 0 as we don't need to pay any coins for 0
        // sum(ways =1 , coins =0) so min coins =0 here
        for (int i = 1; i < dp.length; i++)
            dp[i][0] = 0;

        // 1st row => sum is varying , and we have only 1 coin(first one in array) =>
        // min no of coins = sum/coins[i] if(sum%coins[i]==0) else we can't pay the sum
        // even if we
        // have multiple supplies of the coin so mincoin in that cae= Integer.MAX,
        // example: sum=9, coins={2}=> impossible

        for (int i = 0; i < dp[0].length; i++) {
            // 1-1 => coins[1row-0]=? coins[0] first coins
            dp[1][i] = (sum % coins[1 - 1]) == 0 ? (sum / coins[i]) : Integer.MAX_VALUE - 1;
        }

        // based on unbounded knapsack code
        /**
         * if(arr[i-1]>j){ dp[i][j]= dp[i-1][j] //excluded }
         * 
         * else{ int included =val[i-1]+ dp[i][j-arr[i-1]]
         * 
         * int excluded = dp[i-1][j];
         * 
         * max(included,excluded) }
         * 
         * 
         * Here we doesn't need max value we just neede no of coins included , ie
         * whenever we are making choise to include the coind we do +1 to the past
         * included choices
         * 
         * also we neede to find the minimum so we do min()
         */
        for (int i = 2; i < dp.length; i++) { // 1st row already done
            for (int j = 1; j < dp[0].length; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int included = 1 + dp[i][j - coins[i - 1]];
                    int excluded = dp[i - 1][j];
                    dp[i][j] = Math.min(included, excluded);
                }
            }
        }

        return dp[n][sum];
    }

}
