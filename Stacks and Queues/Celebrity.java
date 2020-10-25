import java.io.*;
import java.util.*;

/**
 * ex: 5 01111 10110 11011 00000 00010 res= 3
 * 
 */

public class Celebrity {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++)
            st.push(i);

        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();
            if (arr[a][b] == 1) {
                // a knows b -> a isn't celebrity
                st.push(b);
            } else {
                st.push(a);
            }
        }

        int potential = st.pop();

        for (int i = 0; i < arr.length; i++) {
            if (i != potential) {
                if (arr[potential][i] == 1) {
                    // if potental celeb knows i -> not a celeb
                    System.out.println("none");
                    return;
                }
                if (arr[i][potential] == 0) {
                    // if i doen't knoe potential celeb -> not a celeb
                    System.out.println("none");
                    return;
                }
            }

        }

        System.out.println(potential);
    }

}