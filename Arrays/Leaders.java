import java.util.Scanner;
import java.util.Stack;

public class Leaders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            System.out.println("Enput the length of array");
            int n = sc.nextInt();
            int ar[] = new int[n];
            // int i = 0;
            for (int i = 0; i < n; i++) {
                ar[i] = sc.nextInt();
            }
            leaders(ar);
        }
        sc.close();
    }

    static void leaders(int ar[]) {
        int maxnum = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<>();
        for (int i = ar.length - 1; i >= 0; i--) {
            if (ar[i] > maxnum) {
                maxnum = ar[i];
                s.push(maxnum);
            }
        }
        while (!(s.isEmpty())) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
    }
}