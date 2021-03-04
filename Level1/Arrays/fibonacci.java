public class fibonacci {
    static int mod = 1000000007;
    static Integer mem[] = new Integer[10000000];

    private static int fibnaive(int n) {
        if (n == 1)
            return 0;
        if (n == 2)
            return 1;
        else
            return (fibnaive(n - 1) % mod + fibnaive(n - 2) % mod) % mod;
    }

    private static int fibnmem(int n) {
        // memoization
        mem[0] = 0;
        mem[1] = 1;

        if (n == 0)
            return mem[0];
        if (n == 1)
            return mem[1];
        if (mem[n] != null)
            return mem[n];
        else {
            mem[n - 1] = fibnmem(n - 1) % mod;
            mem[n - 2] = fibnmem(n - 2) % mod;
            mem[n] = (mem[n - 1] + mem[n - 2]) % mod;
            return mem[n];
        }
    }

    private static int fibdp(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        else {
            Integer dp[] = new Integer[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i < dp.length; i++) {
                dp[i] = (dp[i - 1] % mod + dp[i - 2] % mod) % mod;
            }
            return dp[n];
        }
    }

    private static int fib(int n) {
        int first = 0;
        int second = 1;
        if (n == 1)
            return first;
        if (n == 2)
            return second;
        int count = 3;
        while (count <= n) {
            int res = (first % mod + second % mod) % mod;
            first = second;
            second = res;
            count++;
        }
        return second;
    }

    public static void main(String[] args) {
        int tests[] = { 1, 2, 5, 13, 18, 20, 25, 50, 100, 150 };
        long start, end;
        for (int n : tests) {
            System.out.println("***** N -> " + n + " ****** ");
            if (n > 25) {
                System.out.println("naive takes too long");
            } else {
                start = System.currentTimeMillis();
                System.out.print("Naive : " + fibnaive(n) + " Time : ");
                end = System.currentTimeMillis();
                System.out.println((end - start) + "ms");
            }

            start = System.currentTimeMillis();
            System.out.print("mem : " + fibnmem(n - 1) + " Time : ");
            end = System.currentTimeMillis();
            System.out.println((end - start) + "ms");

            start = System.currentTimeMillis();
            System.out.print("DP : " + fibdp(n - 1) + " Time : ");
            end = System.currentTimeMillis();
            System.out.println((end - start) + "ms");

            start = System.currentTimeMillis();
            System.out.print("Constant Space : " + fib(n) + " Time : ");
            end = System.currentTimeMillis();
            System.out.println((end - start) + "ms \n");
        }
    }
}
