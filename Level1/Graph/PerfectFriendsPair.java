
/**
 * Group/Club of students is there, we have to select students from clubs to form a pair 
 * such that no two friends in a pair belongs to same group.
 *  
 */
import java.io.*;
import java.util.*;

public class PerfectFriendsPair {
    static class Edge {
        int src;
        int nbr;

        Edge(int s, int n) {
            this.src = s;
            this.nbr = n;
        }s
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // vtcs
        int n = Integer.parseInt(br.readLine());
        // edges
        int k = Integer.parseInt(br.readLine());
        // graph creation
        ArrayList<Edge> graph[] = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < k; i++) {
            String association[] = br.readLine().split(" ");
            int v1 = Integer.parseInt(association[0]);
            int v2 = Integer.parseInt(association[1]);
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        // write your code here
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                ArrayList<Integer> comp = new ArrayList<>();
                connected(graph, i, visited, comp);
                comps.add(comp);
            }
        }
        // combinations
        int pairs = 0;
        for (int i = 0; i < comps.size(); i++) {
            for (int j = i + 1; j < comps.size(); j++) {
                int count = comps.get(i).size() * comps.get(j).size();
                pairs += count;
            }
        }

        System.out.println(pairs);
    }

    private static void connected(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp) {
        visited[src] = true;
        comp.add(src);
        for (Edge e : graph[src]) {
            if (visited[e.nbr] == false) {
                connected(graph, e.nbr, visited, comp);
            }
        }
    }

}

// // GFG Way

// import java.io.*;
// import java.util.*;

// public class PerfectFriendsPair {

// static int size = 0;

// private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
// {
// adj.get(u).add(v);
// adj.get(v).add(u);
// }

// private static int dfsUtil(ArrayList<ArrayList<Integer>> adj, boolean[]
// visited, int src, int size) {
// visited[src] = true;

// for (int e : adj.get(src)) {
// if (!visited[e]) {
// return dfsUtil(adj, visited, e, size + 1);
// }
// }
// return size;
// }

// public static void main(String[] args) throws Exception {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// int n = Integer.parseInt(br.readLine());
// int k = Integer.parseInt(br.readLine());
// ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
// for (int i = 0; i < n; i++)
// adj.add(new ArrayList<Integer>());

// for (int i = 0; i < k; i++) {
// String edge[] = br.readLine().split(" ");
// addEdge(adj, Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
// }

// boolean[] visited = new boolean[n];
// int connected_comps = 0;
// ArrayList<Integer> comp = new ArrayList<>();
// for (int i = 0; i < n; i++) {
// if (!visited[i]) {
// size = 1; // clear previos value
// size = dfsUtil(adj, visited, i, size);
// comp.add(size);
// }
// }
// long res = 0;
// for (int i = 0; i < comp.size(); i++) {
// for (int j = i + 1; j < comp.size(); j++) {
// res = res + comp.get(i) * comp.get(j);
// }
// }

// System.out.println(res);
// // System.out.println(comp);

// }

// }