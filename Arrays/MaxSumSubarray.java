import java.util.Scanner;

public class MaxSumSubarray {
    // Kdane Algorithm
    static void maxSubArray(int[] ar) {
        int high, low, current_sum, max_sum;
        low = high = 0;
        current_sum = max_sum = ar[0];
        for (int i = 1; i < ar.length; i++) {
            if (current_sum > 0) {
                current_sum += ar[i];
            } else {
                current_sum = ar[i];
                low = i;
            }

            if (current_sum > max_sum) {
                low = max_sum = current_sum;
                high = i;
            }
        }

        System.out.println("Maximum sum is " + max_sum);
        System.out.println("Subarray start from " + (low + 1) + " and ends at " + (high + 1) + " position");
    }

    public static void main(String[] args) {
        // int ar[] = { 4, 3, -2, 6, 7, -10, -10, 4, 5, 9, -3, 4, 7, -28, 2, 9, 3, 2,
        // 11};
        int ar[] = { 4, 3, -2, 6, 7, -10, -10, 4, 5, 9, -3, 4, 7, -28, 2, 9, 3, 2, -20 };
        maxSubArray(ar);
    }
}
