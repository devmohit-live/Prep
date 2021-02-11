import java.util.*;

public class TargetPair2DSorted {
    public static int approach1(int[][] num1, int[][] num2, int k) {
        // Time and Space: O(N^2) -> no use of sorted property of given matrices
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int arr[] : num1) {
            for (int el : arr) {
                map.put(el, map.getOrDefault(el, 0) + 1);
            }
        }
        for (int arr[] : num2) {
            for (int el : arr) {
                count += map.getOrDefault(k - el, 0);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] mat1 = new int[N][N];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                mat1[i][j] = sc.nextInt();
            }
        }

        int[][] mat2 = new int[N][N];
        for (int i = 0; i < mat2.length; i++) {
            for (int j = 0; j < mat2[0].length; j++) {
                mat2[i][j] = sc.nextInt();
            }
        }
        int K = sc.nextInt();
        System.out.println(approach1(mat1, mat2, K));

    }

}