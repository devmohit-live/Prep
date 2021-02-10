import java.util.PriorityQueue;
import java.util.Scanner;

//O(n) compplexity => current solution
//On(logn) if sorting is done
public class Kth_Largest_Element {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            minheap.add(a[i]);
            if (minheap.size() > k) {
                minheap.remove();
            }
        }

        // minheap will have the k largest elements
        System.out.println(minheap.remove());
    }
}
