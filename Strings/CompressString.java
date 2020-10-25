import java.util.Scanner;

//Compress in tow ways => inp: aaaabbcddddeeaaaabb
// op1: abcdeab
// op2: a3b2cd4e2a4b2
public class CompressString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sb = new String(sc.nextLine());
        op1(sb);
        op2(sb);
    }

    static void op1(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                System.out.print(s.charAt(i));
            }
        }
        System.out.print(s.charAt(s.length() - 1));
        System.out.println();
    }

    static void op2(String s) {
        int count = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                System.out.print(s.charAt(i));
                if (count > 1)
                    System.out.print(count);
                count = 1;
            } else {
                count++;
            }
        }
        System.out.print(s.charAt(s.length() - 1));
        System.out.print(count);

        System.out.println();
    }
}