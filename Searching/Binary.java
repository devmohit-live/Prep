import java.util.Scanner;

public class Binary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fl = 0, cl = 0;
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        int d = sc.nextInt();
        sc.close();
        boolean flag = false;
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == d) {
                flag = true;
                fl = a[mid];
                cl = fl;
                System.out.println("Found at " + mid);
                break;
            } else if (d > a[mid]) {
                low = mid + 1;
                fl = a[mid];
            } else {
                high = mid - 1;
                cl = a[mid];
            }
        }
        if (flag == false)
            System.out.println("Not Found");
        System.out.println("Floor is " + fl + " Ceil is " + cl);
    }
}