import java.util.Arrays;

public class LongestCommonSubSequence {
    /**
     * 27 12
     * 
     * GEBEOCFUFTSXDIXTIGSIEEHKCHZ
     * 
     * DFLILRJQFNXZ
     * 
     * Its Correct output is: 4
     * 
     * And Your Code's output is: 6 -> using hashmap count,
     * 
     * bcz: A subsequence is a sequence that appears in the same relative order
     * RELATIVE ORDER, but not necessarily contiguous. For example, abc, abg, bdf,
     * aeg, acefg, .. etc are subsequences of abcdefg.
     */

    static int[][] mem = new int[1001][1001]; // based on constraints

    // TLE
    static int lcsRecursive(int n, int m, String s1, String s2) {
        // smallest valid input
        if (n == 0 || m == 0)
            return 0;

        // choise diagram

        // last char of both matched
        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            return 1 + lcsRecursive(n - 1, m - 1, s1, s2);

        else {
            // choice 1 :remove last char of first and retain second as it is
            int a = lcsRecursive(n - 1, m, s1, s2);
            // choice 2 :remove last char of second and retain first as it is
            int b = lcsRecursive(n, m - 1, s1, s2);
            // max length is needed
            return Math.max(a, b);
        }
    }

    static int lcsMemoized(int n, int m, String s1, String s2) {
        if (n == 0 || m == 0)
            return 0;

        if (mem[n][m] != -1)
            return mem[n][m];

        // just save every recursive call

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            mem[n][m] = 1 + lcsMemoized(n - 1, m - 1, s1, s2);
        }

        else {
            mem[n][m] = Math.max(lcsMemoized(n - 1, m, s1, s2), lcsMemoized(n, m - 1, s1, s2));
        }
        return mem[n][m];

    }

    public static int lcsTabulation(int n, int m, String s1, String s2) {
        int[][] dp = new int[n + 1][m + 1];
        // 0th row and col ==0

        // from base condition of recursion, or lcs when length of
        // string1 is 0 and string2 varies [0..m] => 0
        // string2 is 0 and string1 varies [0..n] => 0

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR"; // 3 => ADH
        // String s1 = "AGGTAB";
        // String s2 = "GXTXAYB"; // 4 => GTAB
        int n = s1.length();
        int m = s2.length();

        Arrays.stream(mem).forEach(arr -> Arrays.fill(arr, -1));
        // lcsRecursive(n, m, s1, s2); tle
        System.out.println("Using memoization: " + lcsMemoized(n, m, s1, s2));
        System.out.println("Using tabulation: " + lcsTabulation(n, m, s1, s2));
    }
}
