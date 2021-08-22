import java.io.*;
import java.util.*;

/**
 * consider a stream of integers you have to tell kth the largest element
 * whenever a query is raised add n => add number in array find => gives kth
 * largest element till now q=> quit
 * 
 */
public class KminInQuery {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Enter k");
        int k = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        while (true) {
            String s = br.readLine();
            if (s.charAt(0) == 'q')
                break;
            if (s.equals("find"))
                System.out.println(find(pq));
            else {
                String qu[] = s.split(" ");
                int a = Integer.parseInt(qu[1]);
                add(pq, a, k);
            }
        }
    }

    public static int find(PriorityQueue<Integer> pq) {
        int ans = pq.peek();
        System.out.println(pq);
        return ans;
    }

    public static void add(PriorityQueue<Integer> pq, int n, int k) {
        while (pq.size() >= k)
            pq.poll();

        pq.add(n);
    }
}
