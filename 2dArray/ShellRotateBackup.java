import java.util.*;
public class ShellRotate {

    public static int[] matrixTo1d(int[][] a, int s) {
        // logic is based on the spiral matrix
        int minr = s - 1;
        int minc = s - 1; // topleft corner for this shell
        int maxr = a.length - s;
        int maxc = a.length - s; // bottomright most for this shell
        // size of a wall= maxr(or column) -minr(or column) +1
        // size=sizeof_leftwall+sizeof_bottomwall+sizeof_rightwall+sizeof_topwall -4
        // //(-4)each corner is counted twice
        // size=(maxr-minr+1)+(maxc-minc+1)+(maxr-minr+1)+(maxc-minc+1)-4 =>
        // 2*[(maxr-minr+1)+(maxc-minc+1)]-4
        int size = 2 * (maxr - minr + maxc - minc);
        int oned[] = new int[size];
        int counter = 0;
        // +1 -1 logic can be easily ontained by drawing matrix(we don't have to count
        // the same element)(going from lw->bw->rw->tw)

        // lw
        for (int i = minr, j = minc; i <= maxr; i++) {
            oned[counter] = a[i][j];
            counter++;
        }
        // bw
        for (int i = maxr, j = minc + 1; j <= maxc; j++) {
            oned[counter] = a[i][j];
            counter++;
        }
        // rw
        for (int i = maxr - 1, j = maxc; i >= minr; i--) {
            oned[counter] = a[i][j];
            counter++;
        }
        // tw
        for (int i = minr, j = maxc - 1; j >= minc + 1; j--) {
            oned[counter] = a[i][j];
            counter++;
        }

        return oned;
    }

    public static void reverse(int[] oned, int start, int end) {
        while (start < end) {
            int temp = oned[start];
            oned[start] = oned[end];
            oned[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotateShell(int oned[], int r) {
        if (r < 0) {
            r = r + oned.length;
        }
        r = r % oned.length;
        reverse(oned, 0, oned.length - r - 1);
        reverse(oned, oned.length - r, oned.length - 1);
        reverse(oned, 0, oned.length - 1);
    }

    public static void onedToMatrix(int a[][], int[] oned, int s) {
        // exactly as Mtrix to 1 d , here to don't need to create 1d . we just have to
        // set the elements from 1d to matrix in similar fashion

        int minr = s - 1;
        int minc = s - 1; // topleft corner for this shell
        int maxr = a.length - s;
        int maxc = a.length - s;
        int counter = 0;
        // lw
        for (int i = minr, j = minc; i <= maxr; i++) {
            a[i][j] = oned[counter];
            counter++;
        }
        // bw
        for (int i = maxr, j = minc + 1; j <= maxc; j++) {
            a[i][j] = oned[counter];
            counter++;
        }
        // rw
        for (int i = maxr - 1, j = maxc; i >= minr; i--) {
            a[i][j] = oned[counter];
            counter++;
        }
        // tw
        for (int i = minr, j = maxc - 1; j >= minc + 1; j--) {
            a[i][j] = oned[counter];
            counter++;
        }
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int a[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int s = sc.nextInt();
        int r = sc.nextInt();

        int[] oned = matrixTo1d(a, s); // get the shells array
        rotateShell(oned, r); // rotate it
        onedToMatrix(a, oned, s); // put back the rotated array to shell
        // System.out.println();
        display(a);
    }
}




