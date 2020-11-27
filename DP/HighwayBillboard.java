import java.util.*;

public class HighwayBillboard {
    // O(boards*boards) => time
    // O(N)=> space
    public static int solution(int m, int[] x, int[] rev, int t) {
        /*
         * Time:4.67 ms Memory:81124 mb
         */
        int max = 0, ans = 0;
        int dp[] = new int[x.length + 1];
        for (int i = 0; i < x.length; i++) {
            int mx = 0;
            for (int j = 0; j < i; j++) {
                int dist = x[i] - x[j];
                if (dist > t) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + rev[i];

            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    // O(miles) => time
    // O(miles+boards) => space
    public static int solution2(int m, int[] x, int[] rev, int t) {
        /*
         * Time:1.51 ms Memory:83252 mb
         */
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> h = new HashMap<>();

        for (int i = 0; i < x.length; i++) {
            h.put(x[i], rev[i]);
        }

        int dp[] = new int[m + 1];
        dp[0] = 0; // 0 mile doesn't exists

        for (int i = 1; i <= m; i++) {
            if (h.containsKey(i) == false) { // doesn't contains the board at this very mile
                dp[i] = dp[i - 1];
            } else {
                int withoutitself = dp[i - 1];

                int withitself = h.get(i);
                if (i >= t + 1) {
                    withitself += dp[i - t - 1]; // + the kth mile board highest
                }

                dp[i] = Math.max(withoutitself, withitself);
            }

        }
        return dp[m];
    }

    public static void input(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        int x[] = new int[n];
        input(x, scn);

        int revenue[] = new int[n];
        input(revenue, scn);

        int t = scn.nextInt();

        // System.out.println(solution(m, x, revenue, t));
        System.out.println(solution2(m, x, revenue, t));
        scn.close();
    }
}