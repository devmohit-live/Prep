import java.util.*;

public class Boolean_Parenthesization {

    static HashMap<String, Integer> map = new HashMap<>();
    static final int MOD = 1003;

    public static void main(String[] args) {
        // String s = "T^F&T";
        String s = "T|T&F^T"; // 4
        // String s = "T&T|F|F^F^T^T^T&T^F^T&F|F^F^F&F&F|F|F^F^T|T&T"; // 718
        int N = s.length();
        int[][][] mem = new int[N][N][2];
        Arrays.stream(mem).forEach(arr -> Arrays.stream(arr).forEach(a -> Arrays.fill(a, -1)));
        double start, end;
        start = System.currentTimeMillis();
        int resultmem = memoized(s, 0, s.length() - 1, true, mem);
        end = System.currentTimeMillis();
        System.out.println("Mem Matrix : " + resultmem + " takes " + (end - start) + " milliseconds");

        start = System.currentTimeMillis();
        int resultmen2 = memoized(s, 0, s.length() - 1, true);
        end = System.currentTimeMillis();
        System.out.println("Mem Map : " + resultmen2 + " takes " + (end - start) + " milliseconds");

        start = System.nanoTime();
        int result = recursive(s, 0, s.length() - 1, true);
        end = System.nanoTime();
        System.out.println("Using recursion: " + result + " takes " + (end - start) + " milliseconds");
    }

    public static int recursive(String s, int i, int j, boolean isTrue) {
        if (i > j)
            return 0;

        if (i > j)
            return 0;

        if (i == j) {
            if (isTrue == true) {
                return (s.charAt(i) == 'T') ? 1 : 0;
            } else {
                return (s.charAt(i) == 'F') ? 1 : 0;
            }
        }

        // k should be at operator only
        int ans = 0;
        for (int k = i + 1; k < j; k = k + 2) {
            int leftTrue = recursive(s, i, k - 1, true);
            int rightTrue = recursive(s, k + 1, j, true);
            int leftFalse = recursive(s, i, k - 1, false);
            int rightFalse = recursive(s, k + 1, j, false);

            char op = s.charAt(k);

            // boolean maths
            if (op == '&') {
                // true
                if (isTrue) {
                    ans += (leftTrue * rightTrue);
                }
                // false
                else {
                    ans += ((leftFalse * rightFalse) + (leftFalse * rightTrue) + (leftTrue * rightFalse));
                }

            } else if (op == '|') {
                if (isTrue) {
                    ans += (leftTrue * rightTrue + (leftFalse * rightTrue) + (leftTrue * rightFalse));
                }
                // false
                else {
                    ans += (leftFalse * rightFalse);
                }

            } else if (op == '^') {
                if (isTrue) {
                    ans += ((leftFalse * rightTrue) + (leftTrue * rightFalse));
                }
                // false
                else {
                    ans += ((leftFalse * rightFalse) + (leftTrue * rightTrue));
                }
            }

        }

        return ans;
    }

    // using 3d matrix
    public static int memoized(String s, int i, int j, boolean isTrue, int[][][] mem) {

        if (mem[i][j][isTrue ? 1 : 0] != -1)
            return mem[i][j][isTrue ? 1 : 0];

        if (i > j)
            return 0;

        if (i == j) {
            if (isTrue == true) {
                return (s.charAt(i) == 'T') ? 1 : 0;
            } else {
                return (s.charAt(i) == 'F') ? 1 : 0;
            }
        }

        // k should be at operator only
        int ans = 0;
        for (int k = i + 1; k < j; k = k + 2) {

            // we are storing ans in each place not temp value

            // if(mem[i][k-1][1]==-1){
            // mem[i][k-1][1]=recursive(s, i, k - 1, true,mem)%MOD;
            // }
            // if(mem[k+1][j][1]==-1){
            // mem[k+1][j][1]=recursive(s, k + 1, j, true,mem)%MOD;
            // }
            // if(mem[i][k-1][0]==-1){
            // mem[i][k-1][1]=recursive(s, i, k - 1, false,mem)%MOD;
            // }
            // if(mem[k+1][j][0]==-1){
            // mem[k+1][j][0]=recursive(s, k + 1, j, false,mem)%MOD;
            // }

            // int leftTrue = mem[i][k-1][1];
            // int rightTrue = mem[k+1][j][1];
            // int leftFalse = mem[i][k-1][0];
            // int rightFalse = mem[k+1][j][0];

            int leftTrue = memoized(s, i, k - 1, true, mem) % MOD;
            int rightTrue = memoized(s, k + 1, j, true, mem) % MOD;
            int leftFalse = memoized(s, i, k - 1, false, mem) % MOD;
            int rightFalse = memoized(s, k + 1, j, false, mem) % MOD;

            char op = s.charAt(k);

            // boolean maths
            if (op == '&') {
                // true
                if (isTrue) {
                    ans = (ans % MOD + (leftTrue * rightTrue) % MOD) % MOD;
                }
                // false
                else {
                    ans = (ans % MOD + (((leftFalse * rightFalse) % MOD + (leftFalse * rightTrue) % MOD) % MOD
                            + (leftTrue * rightFalse) % MOD) % MOD) % MOD;
                }

            } else if (op == '|') {
                if (isTrue) {
                    ans = (ans % MOD + (((leftTrue * rightTrue) % MOD + (leftFalse * rightTrue) % MOD) % MOD
                            + (leftTrue * rightFalse) % MOD));
                }
                // false
                else {
                    ans = (ans % MOD + (leftFalse * rightFalse) % MOD) % MOD;
                }

            } else if (op == '^') {
                if (isTrue) {
                    ans = ((ans % MOD + ((leftFalse * rightTrue) % MOD + (leftTrue * rightFalse) % MOD)) % MOD) % MOD;
                }
                // false
                else {
                    ans = ((ans % MOD + ((leftFalse * rightFalse) % MOD + (leftTrue * rightTrue) % MOD)) % MOD) % MOD;
                }
            }
        }
        ans = ans % MOD;
        mem[i][j][isTrue ? 1 : 0] = ans;
        return ans % MOD;
    }

    // usign map -> slower runtime
    public static int memoized(String s, int i, int j, boolean isTrue) {
        String key = i + "" + j + "" + (isTrue ? "T" : "F");

        if (map.containsKey(key))
            return map.get(key);

        if (i > j)
            return 0;

        if (i == j) {
            if (isTrue == true) {
                return (s.charAt(i) == 'T') ? 1 : 0;
            } else {
                return (s.charAt(i) == 'F') ? 1 : 0;
            }
        }

        // k should be at operator only
        int ans = 0;
        for (int k = i + 1; k < j; k = k + 2) {

            int leftTrue = memoized(s, i, k - 1, true) % MOD;
            int rightTrue = memoized(s, k + 1, j, true) % MOD;
            int leftFalse = memoized(s, i, k - 1, false) % MOD;
            int rightFalse = memoized(s, k + 1, j, false) % MOD;

            char op = s.charAt(k);

            // boolean maths
            if (op == '&') {
                // true
                if (isTrue) {
                    ans = (ans % MOD + (leftTrue * rightTrue) % MOD) % MOD;
                }
                // false
                else {
                    ans = (ans % MOD + (((leftFalse * rightFalse) % MOD + (leftFalse * rightTrue) % MOD) % MOD
                            + (leftTrue * rightFalse) % MOD) % MOD) % MOD;
                }

            } else if (op == '|') {
                if (isTrue) {
                    ans = (ans % MOD + (((leftTrue * rightTrue) % MOD + (leftFalse * rightTrue) % MOD) % MOD
                            + (leftTrue * rightFalse) % MOD));
                }
                // false
                else {
                    ans = (ans % MOD + (leftFalse * rightFalse) % MOD) % MOD;
                }

            } else if (op == '^') {
                if (isTrue) {
                    ans = ((ans % MOD + ((leftFalse * rightTrue) % MOD + (leftTrue * rightFalse) % MOD)) % MOD) % MOD;
                }
                // false
                else {
                    ans = ((ans % MOD + ((leftFalse * rightFalse) % MOD + (leftTrue * rightTrue) % MOD)) % MOD) % MOD;
                }
            }
        }
        ans = ans % MOD;
        map.put(key, ans);
        return map.get(key);
    }
}
