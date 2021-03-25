// Given two strings X and Y, print the shortest string that has both X and Y as subsequences. If multiple shortest supersequence exists, print any one of them.

// Examples:

// Input: X = "AGGTAB",  Y = "GXTXAYB"
// Output: "AGXGTXAYB" OR "AGGXTXAYB" 
// OR Any string that represents shortest
// supersequence of X and Y

// Input: X = "HELLO",  Y = "GEEK"
// Output: "GEHEKLLO" OR "GHEEKLLO"
// OR Any string that represents shortest 
// supersequence of X and Y

public class PrintShortestCommonSupersequence {
    /**
     * Based on shortes common subsequnces and Print subsequnce(with modification)
     */
    public static void main(String[] args) {
        String str1 = "HELLO", str2 = "GEEK"; //
        // String str1 = "AGGTAB", str2 = "GXTXAYB"; // 9
        int n = str1.length(), m = str2.length();

        shortestCommonSupersequence(str1, str2, n, m);
    }

    static void shortestCommonSupersequence(String s1, String s2, int n, int m) {
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

        int ans_length = m + n - dp[n][m];
        StringBuilder sb = new StringBuilder();

        int i = dp.length - 1;
        int j = dp[0].length - 1;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                // common elemts => was considerd only once
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                // backtrack to previous one (came from )=> max
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    sb.append(s2.charAt(j - 1));
                    j--;
                } else {
                    sb.append(s1.charAt(i - 1));
                    i--;
                }
            }
        }
        // now here it is supersubsequence => ie > lcs(subsequnce must contains
        // characters from both the strings it is A U B) => A+B - A ∩ B

        // as if i!=0 then there are some characters left from string1 which aren't
        // being added to answer

        while (i > 0) {
            sb.append(s1.charAt(i - 1));
            i--;
        }
        // as if j!=0 then there are some characters left from string2 which aren't
        // being added to answer
        while (j > 0) {
            sb.append(s2.charAt(j - 1));
            j--;
        }

        System.out.println("Length of common supersubsequence : " + ans_length);
        System.out.println("common supersubsequence :" + sb.reverse().toString());
    }
}
