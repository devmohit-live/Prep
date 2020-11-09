import java.util.Scanner;

public class SearchInSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int item = sc.nextInt();
        sc.close();

        // Best approach is to start from last index to search element is sorted array
        int i = 0, j = n - 1;
        while (i < n && j < n && i >= 0 && j >= 0) {
            if (item > a[i][j]) {
                ++i; // move to next row
            } else if (item > a[i][j]) {
                --j; // move to previous column
            } else {
                System.out.println("Found at (" + i + "," + j + ")");
                return;
            }
        }
        System.out.println("Not found");
    }
}