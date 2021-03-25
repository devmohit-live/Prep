public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "GeeksforGeeks", s2 = "GeeksQuiz"; // 5
        // String s1 = "abcdxyz", s2 = "xyzabcd"; //4
        // String s1 = "zxabcdezy", s2 = "yzabcdezx"; //6
        int n = s1.length();
        int m = s2.length();
        System.err.println("Length of longest Substring is : " + solve(s1, s2, n, m));

    }

    public static int solve(String s1, String s2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // match

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }

                // discontinuity => substring's length now becomes zero
                else {
                    dp[i][j] = 0;
                }

                /*
                 * substring can exist anywhere in between as we are doing dp[i][j]=0 for
                 * discontinuity so it is not compulsory that lcsubstring wiil be ar n,m it can
                 * be anywhere , so we need to check for every value of i and j
                 */

                ans = Math.max(dp[i][j], ans);
            }
        }

        return ans;
    }
}
/*
 * Sim: longest common between 2 strings
 * 
 * Diff: on discontinuity s1[i]!=s2[j] we put dp[i][j]=0 => possible start for
 * new substring and end of current substring,
 * 
 * Note: the longest substring can be anywhere in between as we have not
 * propogated it , we have done dp[i][j] =0 on several places for discontunuity,
 * so we keep on updating the ans .
 */