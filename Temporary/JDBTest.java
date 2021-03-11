import java.util.Scanner;

public class JDBTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] ch = new char[32];
        ch = sc.next();
        System.out.println(ch);
        System.out.println(printchar(ch));
    }

    public static char[] printchar(char[] ch) {
        return ch;
    }
}
