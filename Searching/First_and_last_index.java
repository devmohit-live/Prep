import java.util.*;

public class First_and_last_index {
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        final int d = sc.nextInt();
        sc.close();
        int lo = 0, high = n - 1, fi = 0;
        while (lo <= high) {
            final int mid = (lo + high) / 2;
            if (d > a[mid]) {
                lo = mid + 1;
            } else if (d < a[mid]) {
                high = mid - 1;
            } else {
                // current optimum index
                fi = mid;
                // first index that is towards left
                high = mid - 1;
            }
        }
        lo = 0;
        high = n - 1;
        int li = 0;
        while (lo <= high) {
            final int mid = (lo + high) / 2;
            if (d > a[mid]) {
                lo = mid + 1;
            } else if (d < a[mid]) {
                high = mid - 1;
            } else {
                // current optimum index
                li = mid;
                // last index that is towards right
                lo = mid + 1;
            }
        }
        System.out.println("First index is : " + fi);
        System.out.println("Last index is : " + li);
    }
}