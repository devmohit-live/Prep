import java.util.Scanner;

public class RotateMatrixClockwise {

    static void inPlaceTranspose(int a[][]) {
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a[0].length; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        System.out.println("After transpose: ");
        show(a);
    }

    public static int[][] transpose(int a[][]) {
        int temp[][] = new int[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                temp[i][j] = a[j][i];
            }
        }
        System.out.println("After transpose: ");
        show(temp);
        return temp;
    }

    static void show(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        int a[][] = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();
        System.out.println("Original: ");
        show(a);
        // a = transpose(a);
        inPlaceTranspose(a);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c / 2; j++) {
                int temp = a[i][j];
                a[i][j] = a[i][c - 1 - j];
                a[i][c - 1 - j] = temp;
            }
        }
        // print
        System.out.println("after operation: ");
        show(a);
    }

}