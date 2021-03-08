
/** Similar to Trap Rain Water */

import java.io.*;
import java.util.*;

public class Largest_Area_Histogram {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> nse = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        // initalizing
        nse.push(0);
        left[0] = -1;
        // nse on left initially -1
        for (int i = 1; i < n; i++) {
            while (nse.size() > 0 && a[i] <= a[nse.peek()]) {
                nse.pop();
            }
            if (nse.size() > 0) {
                left[i] = nse.peek();
            } else {
                left[i] = -1;
            }
            nse.push(i);
        }
        nse = new Stack<Integer>();
        // nse on right initially arr.length
        nse.push(n - 1);// TODO: check todo1
        right[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            while (nse.size() > 0 && a[i] <= a[nse.peek()]) {
                nse.pop();
            }
            if (nse.size() == 0) {
                right[i] = n;
            } else {
                right[i] = nse.peek();
            }
            nse.push(i);
        }

        // net result (r-l +1)*arr[i]

        int max_area = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            // System.out.println(right[i]+" - "+left[i]+" -1 = "+width);
            // System.out.println("Area is : "+ width*a[i]);
            max_area = Math.max(max_area, width * a[i]);
        }

        System.out.println(max_area);
    }
}