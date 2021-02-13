
/**
 * Question Link: https://www.hackerrank.com/challenges/crush/problem
 * 
 * Question is based on Range Addition Concept 
 * 
 * prefix[si]+=k   
 * prefis[ei]+=-k
 * 
 */

import java.io.*;
import java.util.*;

public class ArrayManipulation {

    // O(n+q)
    static long arrayManipulation(int n, int[][] queries) {
        long res = Integer.MIN_VALUE;
        long[] prefix = new long[n + 1];

        for (int i = 0; i < queries.length; i++) {
            int si = queries[i][0];
            int ei = queries[i][1];
            int k = queries[i][2];

            prefix[si] += k;

            if (ei + 1 <= n)
                prefix[ei + 1] += -k;

        }

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] += prefix[i - 1];
        }
        for (int i = 0; i < prefix.length; i++) {
            res = Math.max(res, prefix[i]);
            // System.out.print(prefix[i] + " ");
        }

        return res;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);
        System.out.println(result);
        scanner.close();
    }
}
