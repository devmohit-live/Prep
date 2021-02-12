import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Here we are using 2d fenwick to to summation and point update queries on 2d
 * Arrays the concpet of bits is same here => we just use rectangle (x1,y1)->
 * (x2,y2)
 * 
 * The sum stored in fenwick tree is based on rectangular shape(taking (1,1) the
 * base). so to calculate sum from x1,y1 to x2,y2 we do the follwing : sum(1,1->
 * x2,y2) - sum(1,1 -> x1,y1) but here we can't to that directly(as this is a
 * fenwick array not a regular prefixsum array) so we use the follwong formula:
 * 
 * 1: sum(x2,y2) // 1,1 -> x2,y2 (inclusion)
 * 
 * 2. sum(x1-1,y2) // 1,1 -> x1-1,y2 (exclusion)
 * 
 * 3. sum(x2,y1-1) // 1,1 -> x2,y1-1 (exclusion)
 * 
 * 4. sum(x1-1,y1-1) // 1,1 -> x1-1,y1-1 (inclusion as x1-1,y-1 has been reduced
 * twice (in 2, 3 both))
 * 
 * so netsum -> 1 -2 -3 +4
 * 
 * 
 * Preprocessing of 2d fenwick tree => we use update query of fen[i][j] with
 * delta=arr[i][j] (as used in nlogn approach of fenwick prerprocessing(1d) )
 */

public class Main {
    // global arrays
    static int[][] arr;
    static int[][] fen;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String rc[] = br.readLine().split(" ");
        int r = Integer.parseInt(rc[0]);
        int c = Integer.parseInt(rc[1]);

        arr = new int[r + 1][c + 1];
        for (int i = 1; i < arr.length; i++) {
            String row[] = br.readLine().split(" ");
            for (int j = 1; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(row[j - 1]);
            }
        }

        int q = Integer.parseInt(br.readLine());

        // preprocessing
        preprocess();

        // q => (q*(log n)^2)
        for (int i = 0; i < q; i++) {
            String[] query = br.readLine().split(" ");
            String type = query[0];
            if (type.equals("q")) {
                int x1 = Integer.parseInt(query[1]);
                int y1 = Integer.parseInt(query[2]);
                int x2 = Integer.parseInt(query[3]);
                int y2 = Integer.parseInt(query[4]);
                long res = prefixsum(x1, y1, x2, y2); // (logn)^2
                System.out.println(res);
            } else {
                int x1 = Integer.parseInt(query[1]);
                int y1 = Integer.parseInt(query[2]);
                int delta = Integer.parseInt(query[3]);
                update(x1, y1, delta); // (log n)^2
            }
        }

    }

    // 4* (log n)^2
    private static long prefixsum(int x1, int y1, int x2, int y2) {
        long inclusion1 = summation(x2, y2);
        long exclusion1 = summation(x1 - 1, y2);
        long exclusion2 = summation(x2, y1 - 1);
        long inclusion2 = summation(x1 - 1, y1 - 1);
        long result = inclusion1 - exclusion1 - exclusion2 + inclusion2;
        return result;
    }

    // (nlogn)^2
    private static void preprocess() {
        // update query of whole array
        fen = new int[arr.length][arr[0].length];
        // n^2
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                update(i, j, arr[i][j]); // -> log n* log n
            }
        }

    }

    // log n * log n
    private static long summation(int x, int y) {
        long sum = 0;

        int cpx = x;
        while (cpx > 0) {
            int cpy = y;

            while (cpy > 0) {
                sum += fen[cpx][cpy];
                cpy -= (cpy & -cpy);
            }
            cpx -= (cpx & -cpx);
        }

        return sum;
    }

    // log n * log n
    private static void update(int x, int y, int delta) {
        int cpx = x;
        while (cpx < arr.length) { // logn
            int cpy = y;
            while (cpy < arr[0].length) { // logn
                fen[cpx][cpy] += delta;
                cpy += (cpy & -cpy);
            }
            cpx += (cpx & -cpx);
        }

    }

}
