public class MinDeletionPalindrome {

    // Idea here is to check the diff of length bw string and lps(similar to
    // MinOpeartions and LCS)
    // based on MinOperations and LPS
    // Steps: 1. find lcs of s,reversed(s) => lps,
    // 2.length s- lps
    public static int solve(String S) {
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

        return n - dp[n][n];
    }

    public static void main(String[] args) {
        String a = "geeksforgeeks"; // 8
        String b = "aebcbda"; // 2
        System.out.println("Minimum no. of deletions required to make " + a + " palindrome is :" + solve(a));
        System.out.println("Minimum no. of deletions required to make " + b + " palindrome is :" + solve(b));
    }
}
