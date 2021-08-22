import java.io.*;
import java.util.*;

public class Temp {

    public static int minPalindromicCut(String s) {
        int n = s.length();
        int[][] mem = new int[n][n];
        boolean pal[][] = palindrome(s);
        Arrays.stream(mem).forEach(arr -> Arrays.fill(arr, -1));
        Arrays.stream(pal).forEach(arr ->{ 
            System.out.println(Arrays.toString(arr));} );
        return solve(mem, s, 0, n - 1, pal);
    }

    public static int solve(int[][] mem, String s, int i, int j, boolean[][] pal) {
        int ans = Integer.MAX_VALUE;
        // base
        // invalid
        if (i > j)
            return 0;
        // alreadya a palindrome
        if (pal[i][j])
            return 0;
        // single character is always a palindrome
        if (i == j)
            return 0;

        if (mem[i][j] != -1)
            return mem[i][j];

        for (int k = i; k < j; k++) {

            if (mem[i][k] == -1)
                mem[i][k] = solve(mem, s, i, k, pal);
            if (mem[k + 1][j] == -1)
                mem[k + 1][j] = solve(mem, s, k + 1, j, pal);

            mem[i][j] = mem[i][k] + mem[k + 1][j] + 1;

            ans = Math.min(ans, mem[i][j]);
        }
        return ans;
    }

    public static boolean[][] palindrome(String s) {
        int n = s.length();
        boolean pal[][] = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int gap = j - i;
                if (j > i) {
                    if (gap == 1 && (s.charAt(i) == s.charAt(j))) {
                        pal[i][j] = true;
                    } else if (s.charAt(i) == s.charAt(j) && pal[i + 1][j - 1] == true)
                        pal[i][j] = true;
                }
                if (j == i) { // gap=0
                    pal[i][j] = true;// length 1 -> palindorme
                }

                // i>j -> not palindome invalid case
            }
        }

        return pal;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(minPalindromicCut(str));
    }
}