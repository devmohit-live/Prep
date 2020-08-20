import java.util.Scanner;

/* Lexographical Printing
The problem states given a number n , print all the numbers in lexographical order upto n, ex:
n=1000 =>
1 10 100 1000, 101 102 103...109, 11 110 111 112..119, 12 120 121..129,13....19 190 191...199
# All 1 before 2, all 10,101 before 11    ### call me(1) and my family =>(10 and family, 11 and family ... 19 and family)
2 20 200 201..209, 21,210..219,....   29 290,291..299  ### call me(2) and my family =>(20 and family, 21 and family ... 29 and family)
3 30 300 301...309
4 => 4's family
5 
6
7
8
9
 */

/* Basically here forms a tree type structure in which we have to go depth wise */

public class LexographicalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limit = sc.nextInt();
        // first we will generate all root nodes (1 to 9) and use dfs in it
        for (int i = 1; i < 10; i++) {
            dfs(i, limit);
        }
        sc.close();
    }

    public static void dfs(int i, int n) {
        // we stop the recursion when we have reached the limit
        if (i > n)
            return;
        // Prinitint the values in preorder => node first the childern
        System.out.print(i + " ");
        // printing the family : 1=> 10, i*10+j =>
        for (int j = 0; j < 10; j++) {
            dfs((10 * i) + j, n);
        }
        System.out.println();
    }

}