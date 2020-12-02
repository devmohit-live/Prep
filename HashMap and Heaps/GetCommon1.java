import java.io.*;
import java.util.*;

public class GetCommon1 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int arr[] = new int[n1];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n1; i++) {
            arr[i] = sc.nextInt();
            set.add(arr[i]);
        }

        int n2 = sc.nextInt();
        int arr2[] = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
            if (set.contains(arr2[i])) {
                System.out.println(arr2[i]);
                set.remove(arr2[i]);
            }
        }

    }

}