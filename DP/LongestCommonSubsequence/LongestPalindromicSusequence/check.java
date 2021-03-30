import java.util.*;
import java.lang.*;
import java.io.*;

public class check {
    // print longest palindrromic substring
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        int t = 1;
        while (t-- > 0) {

            // String S = sc.next();
            String S = "otafsngqvoijxuvqbztv";
            System.out.println(S.length());
            String s2 = new StringBuilder(S).reverse().toString();
            int n = S.length();
            int[][] dp = new int[n + 1][n + 1];
            int ans = 0;
            int ansi = 0, ansj = 0;

            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    // match

                    if (S.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    }

                    else {
                        dp[i][j] = 0;
                    }

                    if (ans < dp[i][j]) {
                        ansi = i;
                        ansj = j;
                        ans = dp[i][j];
                    }
                }
            }

            System.out.println(S.charAt(ansi - 1) + " " + ansi);
            System.out.println(S.charAt(ansj - 1) + " " + ansi);

            // Arrays.stream(dp).forEach(arr -> System.out.println(Arrays.toString(arr)));
            System.out.println("length is " + ans);
            StringBuilder sb = new StringBuilder();

            while (ansi > 0 && ansj > 0 && ans > 0) {
                // match
                if (S.charAt(ansi - 1) == s2.charAt(ansj - 1)) {
                    sb.append(S.charAt(ansi - 1));
                    ans--;
                }
                ansi--;
                ansj--;

            }
            System.out.println(sb.reverse().toString());
        }
    }

}
// 1 otafsngqvoijxuvqbztv