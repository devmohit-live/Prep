/* Given a matrix of 0's and 1's find the exot point of matrix, if a man enters from the 0,0 going towards east(initially)
every 1 in a matrix represents and 90 degree turn
*/

import java.util.*;

public class ExitPoint {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int r, c;
        r = sc.nextInt();
        c = sc.nextInt();
        int a[][] = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();
        // east =>col++
        // north => row--
        // west => col--
        // south => row++
        // 1 in array indicates 90 turn
        int dir = 0;// 0-east,1-south,2-west,3-north
        int row = 0, col = 0;
        while (true) {
            dir = (dir + a[row][col]) % 4;
            if (dir == 0)
                col++;
            else if (dir == 1)
                row++;
            else if (dir == 2)
                col--;
            else
                row--;

            if (row == r) {
                row--; // we have to return the index of last door
                break;
            } else if (row < 0) {
                row++; // we have to return the index of last door
                break;
            } else if (col == c) {
                col--; // we have to return the index of last door
                break;
            } else if (col < 0) {
                col++; // we have to return the index of last door
                break;
            }
        }
        System.out.println(row);
        System.out.println(col);
    }
}
