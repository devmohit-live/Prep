import java.io.*;
import java.util.*;

/*
  Example: n=6
  1 8
5 12
14 19
22 28
25 27
27 30

op:
1 12
14 19
22 30
  
  
*/

public class Merger_Overlapping_Intervals {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Pair[] pairs = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }

        Arrays.sort(pairs);

        Stack<Pair> st = new Stack<>();
        Stack<Pair> rs = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                st.push(pairs[i]);
            } else {
                if (pairs[i].st > st.peek().et) {
                    st.push(pairs[i]);
                } else {
                    Pair temp = st.pop();
                    temp.et = Math.max(temp.et, pairs[i].et);
                    st.push(temp);
                }
            }
        }

        while (st.size() > 0) {
            rs.push(st.pop());
        }

        while (rs.size() > 0) {
            Pair tmp = rs.pop();
            System.out.println(tmp.st + " " + tmp.et);
        }

    }

    static class Pair implements Comparable<Pair> {
        int st, et;

        Pair(int st, int et) {
            this.st = st;
            this.et = et;
        }

        public int compareTo(Pair other) {
            if (this.st != other.st)
                return this.st - other.st;
            else
                return this.et - other.et; // if st is same sort on basis of end time
        }

    }

}
