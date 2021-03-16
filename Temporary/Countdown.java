import java.util.*;

//Kickstart class name should be Solution
class Countdown {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int cs = 1; cs <= t; cs++) {
            int output = 0;
            int n = sc.nextInt();
            int k = sc.nextInt();
            // ArrayList<Integer> index = new ArrayList<>();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                // if (arr[i] == k)
                // index.add(i);
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == k) {
                    int x = k;
                    for (int a = i; a < i + k; i++) {
                        if (arr[a] == x) {
                            x--;
                        } else {
                            break;
                        }
                    }

                    if (x == 0) {
                        output++;
                    }
                }
            }

            // if (index.size() == 0 || index.size() * k >= n) {
            // System.out.println("Case #" + cs + ":" + output);
            // continue;
            // }

            // int count = 0;

            // for (int i : index) {
            // count = 1;
            // for (int j = i, itr = 0; j < n - 1 && itr < k; j++, itr++) {
            // if (arr[j] - 1 == arr[j + 1])
            // count++;
            // }
            // if (count == k)
            // output++;
            // }

            System.out.println("Case #" + cs + ":" + output);
        }
    }
}