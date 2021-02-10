import java.util.*;

public class MatrixMulti {
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        int r1, c1, r2, c2;
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        final int[][] one = new int[r1][c1];
        for (int i = 0; i < one.length; i++) {
            for (int j = 0; j < one[0].length; j++) {
                one[i][j] = sc.nextInt();
            }
        }

        r2 = sc.nextInt();
        c2 = sc.nextInt();
        final int[][] two = new int[r2][c2];
        for (int i = 0; i < two.length; i++) {
            for (int j = 0; j < two[0].length; j++) {
                two[i][j] = sc.nextInt();
            }
        }
        final int arr[][] = new int[r1][c2];
        if (c1 != r2) {
            System.out.println("Invalid input");
            return;
        } else {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    for (int k = 0; k < c1; k++) {// or <r2
                        arr[i][j] += one[i][k] * two[k][j];
                    }

                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}