import java.io.*;
import java.util.*;

public class Kosraju {
    /*
     * Kosaraju's algo: Number of strongly connected components
     * 
     * 1. dfs graph and push src at each call to stack at the end
     * 
     * 2. create a new reverseedged grph
     * 
     * 3. dfs the graph on based on stack order
     */

    // a single node is also considered as strongly connected components

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> reverse_edged_graph = new ArrayList<>();

        // 2
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
            reverse_edged_graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1; // to make 0-based indexing
            int v = sc.nextInt() - 1;
            graph.get(u).add(v);
            reverse_edged_graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        // 1
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                dfs(graph, i, visited, stack);
        }

        // visited array initalization for reversed graph
        Arrays.fill(visited, false);

        // 3
        int count = 0;
        while (!stack.isEmpty()) {
            int src = stack.pop();

            if (!visited[src]) {
                dfs(reverse_edged_graph, src, visited);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited, Stack<Integer> stack) {
        visited[src] = true;

        for (int nbr : graph.get(src)) {
            if (!visited[nbr])
                dfs(graph, nbr, visited, stack);
        }

        stack.push(src);
    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited) {
        visited[src] = true;

        for (int nbr : graph.get(src)) {
            if (!visited[nbr])
                dfs(graph, nbr, visited);
        }
    }

}
