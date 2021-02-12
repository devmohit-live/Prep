import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FenwickTree {
    static int[] fen;
    static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1 based indexing
        arr = new int[n + 1];
        fen = new int[n + 1];
        String[] nums = br.readLine().split(" ");
        for (int i = 1; i < arr.length; i++)
            arr[i] = Integer.parseInt(nums[i - 1]);

        int q = Integer.parseInt(br.readLine());

        // // preprocess O(nlogn)
        // preprocess(fen);

        // preprocess O(n)
        preprocessON();
        // executing queries
        for (int i = 0; i < q; i++) {
            String[] lr = br.readLine().split(" ");
            String type = lr[0];

            if (type.equals("q")) {
                int l = Integer.parseInt(lr[1]);
                int r = Integer.parseInt(lr[2]);

                System.out.println(getsum(l, r));

            } else {
                int idx = Integer.parseInt(lr[1]);
                int delta = Integer.parseInt(lr[2]);
                update(idx, delta);
            }

        }

    }

    private static long getsum(int l, int r) {
        return prefixsum(r) - prefixsum(l - 1);
    }

    // log n => no of bits
    private static long prefixsum(int n) {
        long sum = 0;
        while (n > 0) {
            sum += fen[n];
            n -= (n & -n);
        }
        return sum;
    }

    // O(nlogn)
    private static void preprocess(int[] fen) {
        for (int i = 1; i < arr.length; i++) {
            update(i, arr[i]);
        }
    }

    // log n => no of bits
    private static void update(int n, int delta) {
        while (n < fen.length) {
            fen[n] += delta;
            n += (n & -n);
        }
    }

    // here we also use prefixsum array to create fenwick array to create fenwick
    // array in O(N)
    private static void preprocessON() {
        int[] prefix = new int[arr.length];
        // 1 based
        prefix[1] = arr[1];
        for (int i = 2; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        for (int i = 1; i < fen.length; i++) {
            int idx = i - (i & -i);
            fen[i] = prefix[i] - prefix[idx];
        }
    }

}
