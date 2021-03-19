
import java.util.*;

/**
 * There is a range given n and m in which we have to find the count all the
 * prime pairs whose difference is 6. We have to find how many sets are there
 * within a given range.
 * 
 * 
 * 
 * Output:
 * 
 * Output consists of single line, print the count prime pairs in given range.
 * Else print"No Prime Pairs".
 * 
 * 
 * 
 * Constraints:
 * 
 * 2<=n<=1000
 * 
 * n<=m<=2000
 * 
 * 
 * 
 * Sample Input:
 * 
 * 4
 * 
 * 30
 * 
 * 
 * 
 * Output:
 * 
 * 6
 * 
 * 
 * 
 * Explanation:
 * 
 * (5, 11) (7, 13) (11, 17) (13, 19) (17, 23) (23, 29) . we have 6 prime pairs.
 */
public class PrimePairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        boolean isPrime[] = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = m; i <= n; i++) {
            if (prime(i)) {
                set.add(i);
                for (int j = i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int k : set) {
            if (set.contains(k + 6)) {
                System.out.println("k is " + k + "other one is " + (k + 6));
                count++;
            }
        }
        if (count == 0)
            System.out.println("No prime pairs found in this range");
        else {
            System.out.println(count);
        }
    }

    private static boolean prime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
