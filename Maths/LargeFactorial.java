import java.util.*;
import java.math.BigInteger;

public class LargeFactorial {

    private static BigInteger factorial(int n) {
        BigInteger f = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            BigInteger f = factorial(n);
            System.out.println(f);
        }

    }

}