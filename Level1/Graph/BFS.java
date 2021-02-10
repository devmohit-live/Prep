
/**
 * //level order grows in radius // rm*wa*=> remove mark work add
 */

import java.io.*;
import java.util.*;

public class BFS {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    static class Pair {
        int v;
        String psf;

        Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());
        boolean visited[] = new boolean[vtces];
        // write your code here
        bfs(graph, src, visited);
    }

    private static void bfs(ArrayList<Edge> graph[], int src, boolean[] visited) {
        Queue<Pair> q = new ArrayDeque<Pair>();
        q.add(new Pair(src, src + ""));

        while (q.size() > 0) {
            // r
            Pair rm = q.remove();
            if (visited[rm.v] == false) {
                // m*
                visited[rm.v] = true;
                // w
                System.out.println(rm.v + "@" + rm.psf);
                for (Edge e : graph[rm.v]) {
                    if (visited[e.nbr] == false) {
                        // a*
                        q.add(new Pair(e.nbr, rm.psf + e.nbr));
                    }
                }
            }

        }
    }

}