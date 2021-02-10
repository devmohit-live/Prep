import java.util.*;
import java.io.*;

public class Bipartite {
    /**
     * A graph is bipartite if:
     * 
     * 1. The vertices falls into different mutually exclusive and exhaustive sets
     * 2. the edges are bw 2 different sets only (no edge in same sets)
     * 
     * 
     * Acyclic graphs are always Bipartite Cyclic graphs => cycle is of even
     * length=> bipartite cycle is of odd length => not bipartite
     * 
     * Basically set are divided on odd,even level of vertices in BFS instad of
     * making sets we can make visited as an int array that stores level at which
     * they are visited and while traversing if we get any vertex ehich is already
     * being visited:
     * 
     * a) same level => no problem
     * 
     * b) different level:=> not a bipertatite graph(wants to belong to both sets
     * oddlevel adn evenlevel) => immediatly return false;
     */
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    static class Pair {
        int v;
        int level;

        Pair(int v, int level) {
            this.v = v;
            this.level = level;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        // graph ca n be diconnected

        int visited[] = new int[vtces];// stores level at which v is being visited
        Arrays.fill(visited, -1);
        for (int i = 0; i < vtces; i++) {
            for (Edge e : graph[i]) {
                if (visited[e.nbr] == -1) {
                    // not visited
                    if (bfsBipartite(graph, visited, e.nbr) == false) {
                        // if any component is not bipartite then graph isn't bipartite

                        System.out.println(false);
                        return;
                    }
                }
            }
        }
        System.out.println(true);

    }

    public static boolean bfsBipartite(ArrayList<Edge>[] graph, int[] visited, int src) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, 0));
        // rm*wa*
        while (!q.isEmpty()) {
            // r
            Pair rm = q.remove();
            // m*
            // if already visited them there is cycle => different level => retun false
            if (visited[rm.v] != -1) {
                if (visited[rm.v] != rm.level)
                    return false;
            } else {
                visited[rm.v] = rm.level; // marking visited
                // normal bfs
                for (Edge e : graph[rm.v]) {
                    // not visited
                    if (visited[e.nbr] == -1) {
                        q.add(new Pair(e.nbr, rm.level + 1));
                    }
                }
            }
        }
        return true;
    }
}
