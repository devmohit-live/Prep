import java.util.*;

public class Saddle {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();

        int svj = 0;// finding min in row
        for (int i = 0; i < n; i++) {
            // for finding mimimum in ith row
            for (int j = 0; j < n; j++) {
                if (a[i][j] < a[i][svj])
                    svj = j;
            }

            // we have found the min element in a row, now in this column it should be the
            // greatest element , if any other element in this column is greater than then
            // it won't be
            // a saddle point

            boolean isSaddle = true;
            // finding max in that column where min rows value resides
            for (int k = 0; k < n; k++) {
                if (a[k][svj] > a[i][svj]) {
                    isSaddle = false;
                    break;
                }
            }

            if (isSaddle) {
                System.out.println(a[i][svj]);
                return;
            }

        }
        System.out.println("Invalid input");
    }

}