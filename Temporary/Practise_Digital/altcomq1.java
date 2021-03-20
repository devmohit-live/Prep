import java.util.*;

public class altcomq1 {
    /** Get the second highest number */
    // note: array conatins duplicate elements: wasted 8-9 mins figuring out this
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A[] = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println("Solution 1 : " + solve(A));
        System.out.println("Solution 2 : " + solve2(A));
    }

    public static int solve(int[] A) {
        Set<Integer> set = new HashSet<>(); // to remove duplicates
        for (int i : A)
            set.add(i);

        int[] arr = new int[set.size()];
        int i = 0;
        for (int k : set) {
            arr[i] = k;
            i++;
        }
        Arrays.sort(arr);
        int res = arr[arr.length - 2];
        return res;
    }

    public static int solve2(int[] A) {
        Arrays.sort(A);
        int a = A[A.length - 1];
        int i = A.length - 2;
        while (A[i] == a) {
            i--;
        }
        return A[i];
        // System.out.println(A[i]);
    }

}
