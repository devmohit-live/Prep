import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
//Undirected graph

import jdk.internal.org.jline.utils.InputStreamReader;

public class Intro {
    static class Edge {
        int s, n, w;

        Edge(int source, int neighbour, int weight) {
            this.s = source;
            this.n = neighbour;
            this.w = weight;
        }
    }

    // graph => array of arraylist
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of verteces");
        int v=Integer.parseInt(br.readLine());
        ArrayList<Edge> graph[] = new ArryList<Edge>[v];
        for(int i =0;i<v;i++){
            graph[i]= new ArrayList<Edge>; //intitalizing
        }

        System.out.println("Enter no of edges: ");
        int e=Integer.parseInt(br.readLine());
        System.out.println("Enter associations: ");
        for(int i=0;i<e;i++){
            String parts[]= br.readLine().split(" ");
            int v1=parts[0];
            int v2=parts[1];
            int w=parts[2];
            graph[v1].add(new Edge(v1, v2, w));
            graph[v2].add(new Edge(v2, v1, w));
        }


        // graph[0].add(new Edge(0, 1, 10));
        // graph[0].add(new Edge(0, 3, 40));

        // graph[1].add(new Edge(1, 0, 10));
        // graph[1].add(new Edge(1, 2, 10));

        // graph[2].add(new Edge(2, 1, 10));
        // graph[2].add(new Edge(2, 3, 10));

        // graph[3].add(new Edge(3, 0, 40));
        // graph[3].add(new Edge(3, 4, 2));
        // graph[3].add(new Edge(3, 2, 10));

        // graph[4].add(new Edge(4, 3, 2));
        // graph[0].add(new Edge(4, 5, 4));
        // graph[0].add(new Edge(4, 6, 5));

        // graph[5].add(new Edge(5, 4, 4));
        // graph[5].add(new Edge(5, 6, 5));

        // graph[6].add(new Edge(6, 4, 5));
        // graph[6].add(new Edge(6, 5, 3));

    }
}
