import java.util.Scanner;

public class MaxSubArray_Divisible_BY_K {
    public static int solution(int[] a, int k) {
        int ans = 0;
        int sum = 0, rem = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            rem = sum % k;

            if (rem < 0)
                rem += k;
            if (map.containsKey(rem)) {
                int idx = map.get(rem);
                int len = i - idx;
                if (len > ans) {
                    ans = len;
                }
            } else {
                map.put(rem, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }

}
