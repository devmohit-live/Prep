import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SqrtDecomposition {
    /**
     * Finding minimum in range queries: It can also be used when there is an
     * updation in array elements after each query
     * 
     * Time: from O(n*q) to O(n) + O(q*sqrt(n)) Space:
     * O(Math.ceil(Math.sqrt(arr.length)))
     * 
     * Here we map root(n) elements into single box and there are max root(n)+1
     * boxes Why sqrt of n why not other root => bcz it breaks the array and queries
     * into two semmetric halves, so the worst time for each query will be like:
     * 
     * O(root(n)-1 + root(n) + root(n)-1) => O(root(n))
     * 
     * but in other roots say 2/3 root the will becme uneven as the mapping and no
     * of boxes intogether leads to greater complexity
     * 
     * O(root(n)-1 + root(n) + root(n)-1) => O(root(n))
     */

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < nums.length; i++)
            arr[i] = Integer.parseInt(nums[i]);

        int q = Integer.parseInt(br.readLine());
        // len of sqrt array
        int len = (int) Math.ceil(Math.sqrt(arr.length));

        // preprocessing
        int[] srt = preprocess(arr, len);
        // System.out.println("Srt array : " + srt.length + " is the size and ");
        // for (int i : srt) {
        // System.out.print(i + " ");
        // }

        // executing queries
        for (int i = 0; i < q; i++) {
            String[] lr = br.readLine().split(" ");
            int l = Integer.parseInt(lr[0]);
            int r = Integer.parseInt(lr[1]);

            int ans = Integer.MAX_VALUE;
            while (l <= r) {
                // start of box=> i%len==0
                // complete box is under consideration=> l+len-1<=r
                if (l % len == 0 && l + len - 1 <= r) {
                    ans = Math.min(ans, srt[l / len]);
                    l += len;
                } else {
                    ans = Math.min(ans, arr[l]);
                    l++;
                }
            }
            System.out.println(ans);
        }

    }

    private static int[] preprocess(int[] arr, int len) {
        int sqrt[] = new int[len];
        Arrays.fill(sqrt, Integer.MAX_VALUE);
        for (int i = 0; i < arr.length; i++) { // mapping
            int sqrtidx = i / len;
            sqrt[sqrtidx] = Math.min(sqrt[sqrtidx], arr[i]);
        }
        return sqrt;
    }
}
