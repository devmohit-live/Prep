import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Kth_Smallest_Element {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder()); // maxheap
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            maxheap.add(a[i]);
            if (maxheap.size() > k) {
                maxheap.remove();
            }
        }

        // maxheap will have the k largest elements
        System.out.println(maxheap.remove());
    }
}
