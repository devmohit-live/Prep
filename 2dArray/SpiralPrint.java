import java.util.*;

public class SpiralPrint {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int r, c;
        r = sc.nextInt();
        c = sc.nextInt();
        final int[][] arr = new int[r][c];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int total = r * c, count = 0;
        int minr = 0, mincl = 0, maxr = arr.length - 1, maxcl = arr[0].length - 1;
        while (count < total) {
            // left wall -> mincl
            for (int i = minr, j = mincl; i <= maxr && count < total; i++) {
                System.out.println(arr[i][j]);
                count++;
            }
            mincl++;

            // && count < total for last case it's not compulsory that element is surrounded
            // by all 4 walls ex: 3*5
            // bottom wall -> maxr
            for (int i = maxr, j = mincl; j <= maxcl && count < total; j++) {
                System.out.println(arr[i][j]);
                count++;
            }
            maxr--;

            // right wall -> maxcl
            for (int i = maxr, j = maxcl; i >= minr && count < total; i--) {
                System.out.println(arr[i][j]);
                count++;
            }
            maxcl--;

            // top wall -> minr
            for (int i = minr, j = maxcl; j >= mincl && count < total; j--) {
                System.out.println(arr[i][j]);
                count++;
            }
            minr++;
        }
    }
}