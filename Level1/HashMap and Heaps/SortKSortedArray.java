import java.io.*;
import java.util.*;

// Sort Nearly Sorted Array the elemets are k places misplaces atmost
public class SortKSortedArray {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // add first k elemets to the pq
        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }

        // use pq as funnel to filter k+1 elemets
        for (int i = k + 1; i < arr.length; i++) {
            System.out.println(pq.remove());
            pq.add(arr[i]);
        }

        // remove/print rest leftovers
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }

}