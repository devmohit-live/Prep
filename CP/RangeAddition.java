
/**
 * You are given a number N. 
 * 
 * 2. Assume you have an array of length N initialised with all 0's. 
 * 
 * 3. You are also given K update operations.
 * 
 * 4. Each operation contain 3 numbers: startIndex, endIndex and inc and updates each element of
 * the subarray arr[startIndex, endIndex](both inclusive) with inc.
 * 
 * 5. You haveto find the resultant array when all K operations are executed.
 */
import java.util.*;

public class RangeAddition {
    /**
     * This approach is used where we have to give the result after performing q
     * queries not after each queries
     */

    // It takes as input a length and a 2D array of update operations.
    // It should return the modified array.
    public static int[] Range(int length, int[][] updates) {
        int[] res = new int[length];

        for (int i = 0; i < updates.length; i++) {
            int si = updates[i][0];
            int ei = updates[i][1];
            int val = updates[i][2];

            res[si] += val;
            if (ei + 1 < length) {
                res[ei + 1] -= val;
            }
        }

        // prefixsum

        for (int i = 1; i < length; i++) {
            res[i] += res[i - 1];
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for length of first array.
        int length = sc.nextInt();

        int K = sc.nextInt();

        int[][] updates = new int[K][3];

        for (int i = 0; i < updates.length; i++) {
            for (int j = 0; j < updates[0].length; j++) {
                updates[i][j] = sc.nextInt();
            }
        }

        int[] result = Range(length, updates);
        display(result);
        sc.close();
    }

    // function to display an array.
    public static void display(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

}
