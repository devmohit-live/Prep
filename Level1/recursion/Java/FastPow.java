import java.util.Scanner;

public class FastPow {

    public static int fastPow(int a, int b) {
        if (b == 0)
            return 1;
        if ((b & 1) == 1) {
            return a * fastPow(a, b - 1);
        }
        // return fastPow(a * a, b / 2);
        return fastPow(a * a, b >> 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(fastPow(n, k));
        }
        sc.close();
    }
}