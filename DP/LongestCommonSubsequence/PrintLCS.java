import java.util.Arrays;

public class PrintLCS {
    public static void main(String[] args) {
        // String s1 = "acbcf";
        // String s2 = "abcdaf";
        // String s1 = "ABCDGH"; // -> ADH
        // String s2 = "AEDFHR";
        String s1 = "AGGTAB"; // -> GTAB
        String s2 = "GXTXAYB";
        // String s1 = "GEBEOCFUFTSXDIXTIGSIEEHKCHZ"; //-> DIXZ
        // String s2 = "DFLILRJQFNXZ";
        int n = s1.length();
        int m = s2.length();
        System.out.println(solve(s1, s2, n, m));
    }

    public static String solve(String s1, String s2, int n, int m) {
        StringBuilder sb = new StringBuilder();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Arrays.stream(dp).forEach(arr -> System.out.println(Arrays.toString(arr)));

        // ********** Code for finding string

        /*
         * We just have to backtrack in dp based on highest value and from where that
         * value have came from
         */
        int i = dp.length - 1; // =n
        int j = dp[0].length - 1; // =m
        while (i > 0 && j > 0) { // none of the string should be empty
            // matched
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                // characters will be appended only in case of match, for other cases the value
                // has just propagated
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            }
            // unmatched
            else {
                // if not matched then the value in dp[i][j] must have came from max(dp[i-1][j]
                // and dp[i][j-1]) so we will change i, j accordingly
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i = i - 1;
                    // j=j;
                } else {
                    // i=i;
                    j = j - 1;
                }
            }
        }
        /*
         * since search/backtrack go from bottom to top we have got the string in
         * reverse order
         */
        return sb.reverse().toString();
    }
}
