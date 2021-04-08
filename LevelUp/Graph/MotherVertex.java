
/*
Given a Directed Graph, find a Mother Vertex in the Graph (if present). 
A Mother Vertex is a vertex through which we can reach all the other vertices of the Graph.

Print the mother vertex if present else print -1.

Constraints
1<= N <= 10000
1<= M <= (N*(N-1))/2
1<= ai, bi <= N

Sample Input
4 3
1 2
2 3
3 4


add the vertex in dfs at it's end time to the stack  => based on kosaraju's algo

the vertex at the top of stack will be the mother vertex as it can't be somewhere in-between the stack unless there are more than 1 mother vertices
as in dfs we are appending the src at end time in stack so the mother vertex will be added at last.

*/
import java.io.*;
import java.util.*;

public class MotherVertex {
    static Stack<Integer> st;
    static boolean[] visited;
    static int count;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]) - 1;
            int v = Integer.parseInt(str[1]) - 1;
            graph.get(u).add(v);
        }
        visited = new boolean[n];
        st = new Stack<Integer>();
        count = 0;
        System.out.println(findMotherVertex(n, graph));
    }

    public static int findMotherVertex(int N, ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(adj, i);
            }
        }
        count = 0;
        visited = new boolean[N];

        if (st.size() > 0) {
            int ans = st.pop();

            dfsVerify(adj, ans);

            if (count == N)
                return ans + 1; // 1 based indexing
        }

        return -1;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int src) {
        visited[src] = true;
        for (int n : adj.get(src)) {
            if (!visited[n]) {
                dfs(adj, n);
            }
        }
        st.push(src);
    }

    public static void dfsVerify(ArrayList<ArrayList<Integer>> adj, int src) {
        visited[src] = true;
        count++;

        for (int n : adj.get(src)) {
            if (!visited[n]) {
                dfsVerify(adj, n);
            }
        }
    }

}