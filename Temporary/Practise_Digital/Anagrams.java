import java.util.Scanner;

/**
 * Write a program to print all the combinations of the given word with or
 * without meaning (when unique characters are given). ample Input:
 * 
 * abc
 * 
 * 
 * 
 * Output:
 * 
 * abc
 * 
 * acb
 * 
 * bac
 * 
 * bca
 * 
 * cba
 * 
 * ca
 */
public class Anagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        // char ch[] = s.toCharArray();
        anagrams(s, "");
    }

    private static void anagrams(String s, String asf) {

        if (s.length() == 0)
            System.out.println(asf);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i + 1, s.length());
            String roq = left + right;// rest of the question is decremented by 1
            anagrams(roq, asf + c);
        }
    }

    // private static void swap(char ch[], int l, int r) {
    // char tmp = ch[l];
    // ch[l] = ch[r];
    // ch[r] = tmp;
    // }
}
