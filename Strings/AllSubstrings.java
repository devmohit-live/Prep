import java.util.Scanner;

// abcd=> a,ab,abc,abcd,b,bc,bcd,c,cd,d
public class AllSubstrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // substrings => total => n(n+1)/2
        String s = sc.nextLine();
        int count = (s.length() * (s.length() + 1)) / 2, chcheount = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                System.out.println(s.substring(i, j));
                chcheount++; // to verify it is acutallu n*(n+1)/2 or not
            }
        }
        System.err.println("Count " + count + " Ch count " + chcheount);

    }
}