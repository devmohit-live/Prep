import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long d1, v1, d2, v2, p;
        d1 = sc.nextLong();
        v1 = sc.nextLong();
        d2 = sc.nextLong();
        v2 = sc.nextLong();
        p = sc.nextLong();
        if (d1 > d2) {
            int temp = d1;
            d1 = d2;
            d2 = temp;
            temp = v1;
            v1 = v2;
            v2 = temp;
        }

        long start = d1;
        long end = d2;
        long q = 0;
        long res = 0;
        int count = 0;
        while (count < d2 - d1 && p >= 0) {
            p -= v1;
            count++;
        }
        if (count != d2 - d1) {
            System.out.println(count);
        } else {
            res = start - 1 + count;
            long q = (long) Math.floor(p / (v1 + v2));
            if (p - q * (v1 + v2) > 0) {
                res++;
            }
            res += q;
            System.out.println(res);
        }
    }

}
