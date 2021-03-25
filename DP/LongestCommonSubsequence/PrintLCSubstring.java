import java.util.Arrays;

public class PrintLCSubstring {
    public static void main(String[] args) {
        // String s1 = "GeeksforGeeks", s2 = "GeeksQuiz"; // 5
        // String s1 = "abcdxyz", s2 = "xyzabcd"; // 4 abcd
        String s1 = "ABC", s2 = "ACB"; // 1 A
        // String s1 = "ABCDGH", s2 = "ACDGHR"; // 4 -> CDGH
        // String s1 = "zxabcdezy", s2 = "yzabcdezx"; //6
        int n = s1.length();
        int m = s2.length();
        solve(s1, s2, n, m);
    }

    public static void solve(String s1, String s2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        int ansi = 0, ansj = 0;

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

                // ans = Math.max(dp[i][j], ans);
                if (ans < dp[i][j]) {
                    ansi = i;
                    ansj = j;
                    ans = dp[i][j];
                }
            }
        }
        System.out.println("DP Array=> : ");
        Arrays.stream(dp).forEach(arr -> System.out.println(Arrays.toString(arr)));
        System.out.println("\nLength is : " + ans);

        // printing the string
        StringBuilder sb = new StringBuilder();

        while (ansi > 0 && ansj > 0) {
            // match
            if (s1.charAt(ansi - 1) == s2.charAt(ansj - 1)) {
                sb.append(s1.charAt(ansi - 1));
            }

            // always coming from upper diagonal only wheter a match or not
            ansi--;
            ansj--;

            // unmatch -> nothing as dp[][]=>0
        }
        System.out.println("\n" + sb.reverse().toString());
    }

}
