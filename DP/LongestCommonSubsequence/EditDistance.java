public class EditDistance {
    /**
     * LCS based => two string -> int return based on recursive calls we figure out
     * that in case of s1[i] = s2[j] we do 1 + dp[i-1][j-1] bcz of match, else we
     * check for max of dp[i-1][j] and dp[i][j-1]
     * 
     * (cost of performing any of these opearation are equal = 1 )
     * 
     * Here we ate looking for the modifications needed , so on match there is no
     * need for modification therefore dp[i][j] = dp[i-1][j-1] => recursive smaller
     * problem=> carry over value but in the case of mismath we have now 3 choices
     * =>
     * 
     * 1. addition of word in s1 => i-1 +1()for adding a word to s1 s1's length
     * should also be incresed for further recursive calls => i-1 +1 => i, and j
     * will normally do recursive call => dp[i][j-1]
     * 
     * 2. deletion in s2 => dp[i-1][j]
     * 
     * //basically same as lcs calls => dp[i-1][j], dp[i][j-1]
     * 
     * 3. replacing word in s1 to something as in s2 => dp[i-1][j-1]=> nothing added
     * or removed, so both i,j will do normal recursive calls
     * 
     * min(all three choices ) +1 => +1 for mismatch in characters(cost of
     * performing any of these operation)
     */
    public int editDistance(String s, String t) {
        // init
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n + 1][m + 1];
        /**
         * Initialization :
         * 
         * for s1="" , s2=[0..m] x characters are needed to be added in s1 to make s2=>
         * ex: s1="", s2= "a"=> a(1) should be added, s="" s2="abcde" => abcde(5) should
         * be added
         * 
         * Similary when s2="", s1=[0..n] x characters needed to be deleted from s2
         * 
         * basically dp[i][0] = i; dp[0][j]=j
         */
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = i;
        for (int i = 0; i < dp[0].length; i++)
            dp[0][i] = i;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 0 + dp[i - 1][j - 1]; // nothing nneded to be done
                } else {
                    int ins = dp[i][j - 1];
                    int del = dp[i - 1][j];
                    int mod = dp[i - 1][j - 1]; // modificataion
                    dp[i][j] = 1 + Math.min(ins, Math.min(del, mod)); // mismatch handling code => just as val in
                                                                      // knapsack
                }
            }
        }

        // Arrays.stream(dp).forEach(arr -> System.out.println(Arrays.toString(arr)));
        return dp[n][m];
    }
}
