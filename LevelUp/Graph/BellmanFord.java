import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BellmanFord {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        // n- vertices , m edges
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        // storing edges
        int[][] edges = new int[m][3];

        for (int i = 0; i < m; i++) {
            String inp[] = br.readLine().split(" ");
            int u = Integer.parseInt(inp[0]);
            int v = Integer.parseInt(inp[1]);
            int wt = Integer.parseInt(inp[2]);
            edges[i][0] = u;
            edges[i][1] = v;
            edges[i][2] = wt;
        }

        // bellman ford
        bellmanFord(edges, 1, n);

    }

    private static void bellmanFord(int[][] edges, int src, int n) {
        // path for relaxation operation
        int[] path = new int[n + 1]; // 1 based indexing

        Arrays.fill(path, Integer.MAX_VALUE); // intially
        path[src] = 0;
        path[0] = 0;// 1 based numbering of vertices can be ignored

        for (int i = 0; i < n - 1; i++) {
            // all the shortest path is obtained till v-1 iterations bcz:
            /**
             * In non cyclic graph no of edges =v-1 In cyclic the the cycle when completed
             * can not lead to shortes pah and in case on negative cycle shortest path can't
             * be defined so the cyclic graph kind of acts like non-cyclic one's having
             * atnost v-1 edges for shortest paths.
             * 
             */
            for (int[] edge : edges) {
                int u = edge[0];
                int wt = edge[2];
                int v = edge[1];
                // opearions can only be performed if path[u]!=infinity
                if (path[u] == Integer.MAX_VALUE)
                    continue;
                // RELAXATION
                if (path[v] > path[u] + wt) {
                    path[v] = path[u] + wt;
                }

            }
        }

        boolean negCycle = false;

        for (int[] edge : edges) {
            int u = edge[0];
            int wt = edge[2];
            int v = edge[1];
            // opearions can only be performed if path[u]!=infinity
            if (path[u] == Integer.MAX_VALUE)
                continue;
            // RELAXATION
            if (path[v] > path[u] + wt) {
                negCycle = true;
                break;
            }
        }

        if (!negCycle) {
            for (int i = 0; i < path.length; i++) {
                // Printing distance of vertices from src
                if (i == 0 || i == src)
                    continue;
                System.out.println("Vetex: " + i + " is " + path[i] + " distance away");
            }

        } else {
            System.out.println("Graph contains negative cycle");
        }

    }

}
