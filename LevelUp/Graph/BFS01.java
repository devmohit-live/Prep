import java.io.*;
import java.util.*;

/**
 * *** QUESTION ***
 * 
 * You are given 2 integers N and M , N is the number of vertices, M is the
 * number of edges. You'll also be given ai and bi where ai and bi represents an
 * edge from a vertex ai to a vertex bi.
 * 
 * You have to find the minimum number of edges you have to reverse in order to
 * have atleast one path from vertex 1 to N, where the vertices are numbered
 * from 1 to N. Constraints
 * 
 * 1<= N <= 10^4
 * 
 * 1<= M <= 10^6
 * 
 * 1<= ai, bi <= N
 * 
 * Sample Input 7 7 1 2 3 2 3 4 7 4 6 2 5 6 7 5
 * 
 * Sample Output 2
 * 
 * incase the destination can't be reached even after reversing edge print -1
 */
public class BFS01 {

    // *** 01 MEANING *** :
    // Here 01 means that when there is an edge give(u->v) we treat that edges
    // weight as 0 and we create an reverse edge with weight 1, and we try to find
    // the path from src to des with min edges.

    // **** IDEA ****
    // here we print the rem.wt => wt of node (cumulative) as in dijstra with pq =>
    // since actual edges have wt 0 and reverse edges have weight 1, so if the total
    // wt at end is non zero then it will be no of 1's added(which will actually be
    // no. of reversed edges used/ no of edge reversal needed)

    static class Pair {
        int v;
        int wt;

        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    // edge class for storage of edge data(classic) can also be used, here pair
    // class is used for both edge storage and answer

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nm[] = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<Pair>());
        // edges
        for (int i = 0; i < m; i++) {
            String[] sd = br.readLine().split(" ");
            int u = Integer.parseInt(sd[0]) - 1;
            int v = Integer.parseInt(sd[1]) - 1;

            // actual edge
            graph.get(u).add(new Pair(v, 0));

            // reverse edge(for algorithm)(cost of 1)
            graph.get(v).add(new Pair(u, 1));
        }

        // 0-1 bfs => dijsktra without priority queue decreasing the time complexity
        // with logv (use this when we have restriction on wt of edges)
        LinkedList<Pair> q = new LinkedList<>();
        int src = 0;
        int des = n - 1;

        q.addFirst(new Pair(src, 0));

        while (q.size() > 0) {
            Pair rem = q.removeFirst();
            visited[rem.v] = true;

            if (rem.v == des) {
                System.out.println(rem.wt);
                return;
            }

            for (Pair p : graph.get(rem.v)) {
                if (!visited[p.v]) {
                    if (p.wt == 0) {
                        // q
                        q.addFirst(new Pair(p.v, p.wt + 0));
                    } else {
                        // q+1
                        q.addLast(new Pair(p.v, p.wt + 1));
                    }

                }

            }

        }
        System.out.println(-1);

    }
}
