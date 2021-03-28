import java.util.*;

public class MCM {
    public static void main(String[] args) {
        int N = 5;
        int[] arr = { 40, 20, 30, 10, 30 };// 26000
        // int N = 4;
        // int[] arr = { 10, 30, 5, 60 }; // 4500

        int mem[][] = new int[N][N];
        Arrays.stream(mem).forEach(ar -> Arrays.fill(ar, -1));

        // i=1 not 0 since we need both m,n so if we start with i=0 we can't get the
        // first dimention
        int ansMem = solveMem(arr, 1, N - 1, mem);
        int ansRecu = solveRecur(arr, 1, N - 1);
        System.out.printf("Answer :\n Using Recursion %d \n Using Memoization %d:", ansRecu, ansMem);
    }

    static int solveRecur(int[] arr, int i, int j) {
        int ans = Integer.MAX_VALUE;
        // base -> actual -> i>j -> return 0, for matrix to get both dimension(m,n) we
        // require two values in recuirsion so when i==j we only have 1 value left so
        // this is also an invalid case
        if (i >= j)
            return 0;

        // k scheme => either i<=k, k<j -> solve(i,k) & solve(k+1,j) or
        // i<k<=j -> solve(i,k) & solve(k-1,j)
        for (int k = i; k <= j - 1; k++) {
            int temp = solveRecur(arr, i, k) + solveRecur(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            ans = Math.min(ans, temp); // store the min for each iteration
        }
        return ans;
    }

    static int solveMem(int[] arr, int i, int j, int[][] mem) {
        int ans = Integer.MAX_VALUE;
        // base
        if (i >= j)
            return 0;
        if (mem[i][j] != -1)
            return mem[i][j];
        // k scheme
        for (int k = i; k <= j - 1; k++) {
            mem[i][k] = solveMem(arr, i, k, mem);
            mem[k + 1][j] = solveMem(arr, k + 1, j, mem);
            int temp = mem[i][k] + mem[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
            ans = Math.min(ans, temp);
            mem[i][j] = ans;
        }
        return ans;
    }
}
