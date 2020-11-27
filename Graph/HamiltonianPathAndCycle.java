
/**
 * A Hamiltonian path, also called a Hamilton path, is a graph path between two
 * vertices of a graph that visits each vertex exactly once.
 * 
 * Path => end with . Cycle => ends at *
 * 
 * similar to printAllPaths => src to dest direct path in hamiltonian path =>
 * hamiltoninan cycle
 */
import java.io.*;
import java.util.*;

public class HamiltonianPathAndCycle {
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

        int src = Integer.parseInt(br.readLine());
        HashSet<Integer> visited = new HashSet<>();
        hamiltonian(graph, src, visited, src, src + "");

    }

    private static void hamiltonian(ArrayList<Edge> graph[], int src, HashSet<Integer> visited, int osrc, String psf) {

        if (visited.size() == graph.length - 1) {
            System.out.print(psf);

            boolean isCycle = false;

            for (Edge e : graph[src]) {
                if (osrc == e.nbr) {
                    isCycle = true;
                    break;
                }
            }

            if (isCycle == true)
                System.out.println("*");
            else
                System.out.println(".");

            return;
        }

        visited.add(src);

        for (Edge e : graph[src]) {
            if (visited.contains(e.nbr) == false) {
                hamiltonian(graph, e.nbr, visited, osrc, psf + e.nbr);
            }
        }
        visited.remove(src);
    }

}