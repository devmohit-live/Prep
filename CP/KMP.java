import java.util.*;

public class KMP {
    /**
     * @author : devmohit-live
     * 
     *         link to concept: https://youtu.be/__Cu92rei1s
     * 
     *         String: aabc Prefix(a): a, ab, aab,aabc, Suffix(c): c,bc,abc,aabc
     * 
     *         Proper Prefix: all prefix - complete strings(not a absoulte prefix)=>
     *         a, ab, aab
     *
     *         Proper Sufffix: all suffix - complete strings(not a absoulte
     *         prefix)=> c,bc,abc
     * 
     *         Works on the concept of LPS(Longest Proper Suffix)=> text=given
     *         string, pat=given pattern new String s2= pat + "#" + text
     * 
     *         now apply lps on s2 , then ierate throug lps op array do count++
     *         wherever lps[i]==pat.length
     * 
     */

    public static int[] lps(String s) {
        int[] lpsop = new int[s.length()];
        int i = 1, len = 0;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lpsop[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lpsop[len - 1];

                } else {
                    lpsop[i] = 0;
                    i++;
                }
            }
        }
        return lpsop;
    }

    public static int kmp(String text, String pat) {
        int count = 0;
        String s = pat + "#" + text;
        int[] res = Arrays.copyOfRange(lps(s), pat.length(), s.length());
        // to get the actual aray as original array also contains the pattern and #
        System.out.println("lps:");
        for (int i = 0; i < res.length; i++)
            if (res[i] == pat.length()) {
                System.out.println("pattern found at index: " + (i - pat.length()));
                count++;
            }
        return count;
    }

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        System.out.println("Enter text and patter to search");
        String text = sc.next();
        String pattern = sc.next();
        // O(n) time complexity of kmp
        System.out.println("Text contains " + kmp(text, pattern) + " occurances of pattern");
        sc.close();
    }
}
