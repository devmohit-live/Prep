public class LPS {
    /**
     * LPS(String a) === LCS(String a, reverse(String a))
     */
    public static void main(String[] args) {
        String a = "abcd"; // 1
        String b = "bbabcbcab"; // 7
        String c = "geeksforgeeks"; // 5

        System.out.println("Lonngest Palindromic subsequence for " + a + " is " + longestPalinSubseq(a));
        System.out.println("Lonngest Palindromic subsequence for " + b + " is " + longestPalinSubseq(b));
        System.out.println("Lonngest Palindromic subsequence for " + c + " is " + longestPalinSubseq(c));
    }

    public static int longestPalinSubseq(String S) {
        String s2 = new StringBuilder(S).reverse().toString();
        int n = S.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (S.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[n][n];
    }
}
