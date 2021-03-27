import java.util.HashMap;

public class LongestReapeatingSubsequnce {
    /**
     * Input: str = "aabb" Output: 2 ->"ab"
     */
    public static void main(String[] args) {
        // String s1 = "axxxy"; // 2
        String s1 = "pfoslsszfx"; // 2
        String s2 = new String(s1);

        // just modified the code to avoid counting same elements from both the copies
        // ex
        // s1[1]=s2[1] are pointing to same X , but s1[1],s2[2] are pointing to
        // different x (both are character x but they are not the same -> same marks
        // different student, same value different memory)
        System.out.println("Using dp " + lcs_modified(s1, s2));
        // System.out.println("Check ");
        // approach1(s1);

    }

    public static int lcs_modified(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        // init =0 as in lcs

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1) && i != j) { // added i!=j
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        printSequence(dp, s1, s2);
        return dp[n][m];
    }

    public static void printSequence(int[][] dp, String s1, String s2) {
        int i = dp.length - 1; // =n
        int j = dp[0].length - 1; // =m
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) { // none of the string should be empty
            // matched
            if (s1.charAt(i - 1) == s2.charAt(j - 1) && i != j) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            }
            // unmatched
            else {

                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i = i - 1;
                    // j=j;
                } else {
                    // i=i;
                    j = j - 1;
                }
            }
        }
        System.out.println(sb.reverse().toString());
    }

    // // Reason why this doesn't work:
    // // fails here pfoslsszfx
    // /**
    // * Its Correct output is: 2
    // *
    // * And Your Code's output is: 3
    // *
    // */
    // static void approach1(String s) {
    // HashMap<Character, Integer> map = new HashMap<>();
    // for (char c : s.toCharArray()) {
    // map.put(c, map.getOrDefault(c, 0) + 1);
    // }
    // System.out.println(map);
    // int sum = 0;
    // StringBuilder sb = new StringBuilder();

    // for (char c : s.toCharArray()) {
    // if (map.get(c) > 1) { // repeating
    // int t = map.get(c) - 1;
    // sum += t;
    // for (int i = 0; i < t; i++)
    // sb.append(c);
    // // removing that character now
    // map.put(c, 0);
    // }
    // }
    // System.out.println("length is :" + sum + " string is : " + sb.toString());
    // }
}
