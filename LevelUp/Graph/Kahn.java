import java.io.*;
import java.util.*;

// Kahn's Algo : Iterative way of finding topological sort(bfs based uses indegree of vertices)

// ****  NOTE: ****
// Applicable to only DAG as in case of cycle there will exists deadlock, hence no ordering is possible, so this alfo can also be used to tell whether a graph is DAG or not ot cyclic or not(cycle detection)

// ****  Steps: 
/*

1. Calculate indegree of vertices

2. for vertices having indegree =0 add them to the queue for bfs, if there isn't any vertex having indegree=0 then threre exists a cycle so topological sorting is not possible

3. during traversal also increment the counter(whenever we remove item from queue) ans add the src to ans

4. while traversing do indegre-- for all the neighbours of source (removed from the Queue) and if at any point indegre[nbr] becomes 0 add this nbr to the queue

5. at last if counter== total no of vertixes then print the topological sort or else there was cycle somewhere hence no ordering os possible

*/
public class Kahn {

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n);
        int indegree[] = new int[n];
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<Integer>());

        // 1
        // if we have control over the input
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            indegree[v]++;
        }

        /// if graph is already given in the fuction like in gfg, hackerrank, then
        // for (int i = 0; i < n; i++) {
        // for (int nbr : graph.get(i)) {
        // indegree[nbr]++;
        // }
        // }

        // 2
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        int[] ans = new int[n];
        int count = 0;
        // 3,4
        while (q.size() > 0) {
            int rem = q.remove();
            // 3
            ans[count] = rem;
            count++;

            for (int nbr : graph.get(rem)) {
                indegree[nbr]--; // 4

                if (indegree[nbr] == 0)
                    q.add(nbr);
            }

        }
        // 5
        if (count == n) {
            System.out.println("The possible ordering is :");
            for (int i : ans)
                System.out.print(i + " ");
        } else
            System.out.println("Graph is not a Direct Acyclic Grpah (contains cycle)");
    }
}
