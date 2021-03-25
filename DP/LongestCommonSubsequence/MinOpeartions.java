public class MinOpeartions {
    public static void main(String[] args) {
        String a = "heap", b = "pea"; // 3 => 2del , 1ins
        // String a = "geeksforgeeks", b = "geeks"; // 8 => 8 deletions, 0 insertions
        minOperations(a, b);
    }

    public static void minOperations(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // first we convert string a to lcs => deletion
        int del = n - dp[n][m];
        // then we convert lcs to b => insertion
        int ins = m - dp[n][m];
        System.out.println("There are total " + (del + ins) + " operations having " + del + " deltions and " + ins
                + " insertions");
    }
}
