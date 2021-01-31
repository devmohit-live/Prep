import java.util.Scanner;

public class ZAlgoPatternMatching {
    /**
     * @author : devmohit-live
     * 
     *         link to concept: https://youtu.be/QlwzsWs0oyc
     * 
     *         String: aabc Prefix(a): a, ab, aab,aabc, Suffix(c): c,bc,abc,aabc
     * 
     *         Proper Prefix: all prefix - complete strings(not a absoulte prefix)=>
     *         a, ab, aab
     *
     *         Proper Sufffix: all suffix - complete strings(not a absoulte
     *         prefix)=> c,bc,abc
     * 
     *         Works on the concept of Z function=> text=given string, pat=given
     *         pattern new String s2= pat + "#" + text
     * 
     *         now apply Z fx on s2 , then iterate through z array do count++
     *         wherever z[i]==pat.length
     * 
     */

    public static int[] zFuntion(String s) {
        int n = s.length();
        int l = 0, r = 0;
        int[] z = new int[n];
        for (int i = 0; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }

            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }

            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }

    public static void Zalgo(String text, String pattern) {
        int[] sol = zFuntion(s2 + "#" + s1);
        System.out.println("Indexes where patterns are found: ");
        for (int i = 0; i < sol.length; i++)
            if (sol[i] == s2.length()) {
                // starting index after pattern#
                System.out.println(i - s2.length() - 1);
            }
    }

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        System.out.println("Enter text and patter to search");
        String text = sc.next();
        String pattern = sc.next();
        // O(n+m) time complexity of Zalgo
        System.out.println("Text contains " + Zalgo(text, pattern) + " occurances of pattern");
        sc.close();
    }
}
