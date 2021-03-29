import java.util.*;

public class PalindromePartioning {
    public static void main(String[] args) {
        String str = "ABCBC";
        System.out.println(palindromicPartition(str));
    }

    static int palindromicPartition(String str) {
        int n = str.length();
        int[][] mem = new int[n][n];

        Arrays.stream(mem).forEach(arr -> Arrays.fill(arr, -1));
        // we can start i=0 here
        int result = solve(mem, str, 0, n - 1);
        return result;
    }

    // O(n*n*n) n* n for loop and n for isPalindome => TLE in online judges
    public static int solve(int[][] mem, String s, int i, int j) {
        int ans = Integer.MAX_VALUE;
        // base
        // invalid
        if (i > j)
            return 0;
        // alreadya a palindrome
        if (isPal(s, i, j))
            return 0;
        // single character is always a palindrome
        if (i == j)
            return 0;

        if (mem[i][j] != -1)
            return mem[i][j];

        for (int k = i; k < j; k++) {

            if (mem[i][k] == -1)
                mem[i][k] = solve(mem, s, i, k);
            if (mem[k + 1][j] == -1)
                mem[k + 1][j] = solve(mem, s, k + 1, j);

            mem[i][j] = mem[i][k] + mem[k + 1][j] + 1;

            ans = Math.min(ans, mem[i][j]);
        }
        return ans;
    }

    public static boolean isPal(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;

            start++;
            end--;
        }
        return true;
    }
}
