import java.util.*;

public class StringCorrection {
    /**
     * Similar to batting problem How many ways the correct word can be formed from
     * incorrect word in case of match of inc.charAt(i-1), co.charAt(j-1) =>
     * 
     * contrinution with me + contrinution wothout me(according to previous
     * battle/case -> above row)
     * 
     * if charcter does'nt math => same data from exact above row
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inc = sc.next();
        String co = sc.next();
        if (inc.equals(co))
            System.out.println(0);
        else
            System.out.println(solve(inc, co));
    }

    public static int solve(String inc, String co) {
        int m = inc.length();
        int n = co.length();
        int[][] lookup = new int[m + 1][n + 1]; // distinct contribution with and without

        // for (int i = 0; i <= n; i++) {
        // lookup[0][i] = 0;
        // }

        for (int i = 0; i <= m; i++) {
            lookup[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (inc.charAt(i - 1) == co.charAt(j - 1))
                    lookup[i][j] = lookup[i - 1][j - 1] + lookup[i - 1][j];
                else
                    lookup[i][j] = lookup[i - 1][j];
            }
        }

        return lookup[m][n];
    }
}
