import java.util.*;

/** 21 March am directory  Substring and distinct characters*/
/**
 * Causes runtime in private cases to be modified
 */

public class SubstringDistinct {
    public static void main(String[] args) {
        // int n = 4;
        // String s = "aabc";
        int n = 3;
        String s = "abc";

        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray())
            set.add(c);

        int rep = n - set.size();
        int res[] = new int[26];
        if (n == 0) {
            for (int i : res) {
                System.out.print(i + " ");
            }
        }
        if (n == 1) {
            res[0] = 1;
            for (int i : res) {
                System.out.print(i + " ");
            }
        } else {
            res[0] = (n * (n + 1)) / 2;
            solver(s, n, rep, res);
            for (int i : res)
                System.out.print(i + " ");

        }

    }

    public static void solver(String s, int n, int rep, int[] res) {
        int i = 0, j = i + 1;
        int curr = 0;
        int ans = 0;
        int idx = 1;
        while (j < n) {
            while (s.charAt(i) == s.charAt(j))
                j++;

            if (j >= n) {
                res[idx] = 0;
                break;
            }
            curr = n - j;
            if (rep == 0)
                ans = ((curr) * (curr + 1)) / 2;
            else
                ans = ((curr + 1) * (curr + 2)) / 2;
            ans -= rep;
            res[idx] = ans;
            i = j;
            j = i + 1;
            idx++;
            if (ans == 0)
                break;
        }

    }

}
