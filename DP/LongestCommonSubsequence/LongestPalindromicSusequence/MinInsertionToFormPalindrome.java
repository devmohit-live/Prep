public class MinInsertionToFormPalindrome {
    /**
     * Question is exact same / duplicate of Minimum no. of deletions reuired to
     * form a palindrome from a string there we were deleting the words that don;t
     * have pairs , ex: fjabccbade, here f,j,d,e don't have pair so we delete them
     * to from abccba => 4
     * 
     * In insertion we just add those pairs, ex: fjabccbade we add f,j,d,e to
     * appropriate places to make fjedabccbadejf => 4
     * 
     */
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

        return n - dp[n][n]; // s.length - palindromic subsequnce => required addition
    }

    public static void main(String[] args) {
        String a = "geeksforgeeks"; // 8
        String b = "aebcbda"; // 2
        System.out.println("Minimum no. of insertion required to make " + a + " palindrome is :" + solve(a));
        System.out.println("Minimum no. of insertion required to make " + b + " palindrome is :" + solve(b));
    }
}
