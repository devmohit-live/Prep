
/**
 * Given two strings str1 and str2, the task is to find the length of the
 * shortest string that has both str1 and str2 as subsequences.
 * 
 * Input: str1 = "geek", str2 = "eke" Output: 5 Explanation: String "geeke" has
 * both string "geek" and "eke" as subsequences.
 * 
 * Input: str1 = "AGGTAB", str2 = "GXTXAYB" Output: 9 Explanation: String
 * "AGXGTXAYB" has both string "AGGTAB" and "GXTXAYB" as subsequences.
 */

public class SortestCommonSupersequence {
    /**
     * IDEA:
     * 
     * the idea here is to find the lcs as A U B => A + B - A ∩ B
     * 
     * length a + length b - length of common sunsequence
     */
    public static void main(String[] args) {
        String str1 = "geek", str2 = "eke"; // 5
        // String str1 = "AGGTAB", str2 = "GXTXAYB"; //9
        int n = str1.length(), m = str2.length();
        System.out.println("Length of shortes common subsequence containing both strings is "
                + shortestCommonSupersequence(str1, str2, n, m));
    }

    public static int shortestCommonSupersequence(String s1, String s2, int n, int m) {
        int ans = m + n;
        ans -= lcs(s1, s2, n, m);
        return ans;
    }

    static int lcs(String s1, String s2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[n][m];
    }
}
