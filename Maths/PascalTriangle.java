import java.util.Scanner;

public class PascalTriangle {
    /**
     * Useful in finding coeffcients in binomial expansion
     * 
     * Useful in finding combinations in form of: nCr ex: no of ways in which tails
     * appers exactly 2times in 6 coins
     * 
     * for r>> use this concept : nCr = nCn-r
     * 
     * 0 row and col represents 0 selection pascal[0][0]=1, pascal[i][j]=1 for i==j
     */

    static long[][] pascal = new long[1000][1000]; // contrains in case of range queries of r,c acc to question
    static int mod = 1000000007;

    static void createPascalTriangle() {
        pascal[0][0] = 1;
        for (int i = 0; i < pascal.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    pascal[i][j] = 1;
                else if (i == j)
                    pascal[i][j] = 1;
                else {
                    // to avoid value overflow
                    pascal[i][j] = (pascal[i - 1][j - 1] % mod + pascal[i - 1][j] % mod) % mod;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // PREPROCESSING
        createPascalTriangle();

        System.out.print("No of ways of getting 2 tails on a toss of 6 coins : ");
        // 6c2 => pascal[6][2];
        System.out.println(pascal[6][2]);
        System.out.println("Probability of getting 2 tails in toss of 6 coins " + ((pascal[6][2] * 1.0) / (6 * 6)));

        System.out.println("4th coefficient's value in (a+b)^8 " + pascal[8][4]);

        // max coefficient :
        /**
         * For n=even : r=n/2 +1
         * 
         * For n=odd : r= (n+1)/2 or (n-1)/2
         */

        // 100C97 = 100C3 => ncr=ncn-r
        System.out.println("value of 10C8: " + pascal[10][8]);
        System.out.println("value of 10C2 == 10C8: " + pascal[10][10 - 8]);

        System.out.println("Find max Coefficient : ");
        System.out.println("Enter t: ");

        int r;
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.print("Enter the value of n(power of binomial) : \n");
            int n = sc.nextInt();

            if ((n & 1) == 1) {
                r = (n + 1) / 2;
            } else {
                r = n / 2;
            }
            System.out.println("Max value of coefficient is: " + n + "C" + r + " with value of " + pascal[n][r]);
        }
        sc.close();
    }

}
