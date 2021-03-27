public class IsSubSequce {

    // 2 pointer approach
    boolean isSubSequence(String A, String B) {
        int i = 0, j = 0, count = 0;
        int al = A.length();
        int bl = B.length();
        while (i < al && j < bl) {
            if (A.charAt(i) == B.charAt(j)) {
                i++;
                j++;
                count++;
            } else {
                j++;
            }
        }

        return (count == al);
    }

    // dp
    public boolean isSubsequencedp(String s, String t) {
       int n=s.length();   
       int m=t.length();   
        int[][] dp =new int[n+1][m+1];
      
      for(int i=1;i<dp.length;i++){
        for(int j=1;j<dp[0].length;j++){
          if(s.charAt(i-1)==t.charAt(j-1)){
            dp[i][j]= 1 + dp[i-1][j-1];
          }else{
             dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]) ;
          }
          
        }
      }
      
      return dp[n][m]==n;
      
}
