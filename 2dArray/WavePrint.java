import java.util.Scanner;

public class WavePrint {
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        int r, c;
        r = sc.nextInt();
        c = sc.nextInt();
        final int arr[][] = new int[r][c];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // sol
        for (int i = 0; i < arr[0].length; i++) { // column is increasing always
            // if column is even we are increasing rows(goind down) and vise versa
            if ((i & 1) == 1) {
                for (int j = arr.length - 1; j >= 0; j--) {
                    System.out.println(arr[j][i]);

                }
            } else {
                for (int j = 0; j < arr.length; j++) {
                    System.out.println(arr[j][i]);
                }
            }
        }
    }
}
