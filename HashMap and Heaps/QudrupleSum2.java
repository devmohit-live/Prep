import java.util.*;

public class QuadrpuleSum2 {

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                hm.put(a + b, hm.getOrDefault(a + b, 0) + 1);
            }
        }
        int target = 0;

        for (int a : C) {
            for (int b : D) {
                int to_find = target - (a + b);
                // similar to two sum approach we find b=target-a
                // here target=0
                count += hm.getOrDefault(to_find, 0);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];
        int[] arr4 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr3[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr4[i] = sc.nextInt();
        }
        System.out.println(fourSumCount(arr1, arr2, arr3, arr4));
    }

}