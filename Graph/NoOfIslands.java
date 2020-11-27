
/**
 * Here the 2d matrix will act as graph and each cell is a vertex the cells
 * around it are it's neighbours , edges are invisible here Same as get
 * connected components => graph=matrix, vtc=cell, visited will be 2d here
 * condition => cell is not visited and cell is an island(0)
 * 
 * there we go to neighbours using arraylist but here we have to got to each
 * neighbours through manual recursive calls n,e,w,s calls => i-1,i+1,j-1,j+1
 */
import java.io.*;
import java.util.*;

public class NoOfIslands {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }

        boolean visited[][] = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == false && arr[i][j] == 0) {
                    // src => i,j th position
                    connected(arr, i, j, visited);
                    count++;
                }
            }

        }
        System.out.println(count);
    }

    private static void connected(int[][] graph, int i, int j, boolean[][] visited) {
        // boundary, water or marked => boundary to be checked first in ||
        if (i < 0 || i >= graph.length || j < 0 || j >= graph[0].length || visited[i][j] == true || graph[i][j] == 1) {
            return;
        }

        // mark
        visited[i][j] = true;

        // calls
        connected(graph, i - 1, j, visited);
        connected(graph, i + 1, j, visited);
        connected(graph, i, j - 1, visited);
        connected(graph, i, j + 1, visited);
    }

}