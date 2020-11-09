import java.util.*;

/**
 * Next Greater elemnt to the right
 */

public class Nger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int nge[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Stack<Integer> s = new Stack<>();
        s.push(0); // pushing forst index
        for (int i = 1; i < n; i++) {
            while (s.size() > 0 && a[i] >= a[s.peek()]) {
                int pos = s.peek();
                nge[pos] = a[i];
                s.pop();
            }
            s.push(i);
        }
        // elements left on the stack having no right greater elements
        while (s.size() > 0) {
            nge[s.peek()] = -1;
            s.pop();
        }

        System.out.println();
        for (int i = 0; i < nge.length; i++) {
            System.out.print(nge[i] + " ");
        }

        System.out.println("Apprpach 2");
        approach2(a);
    }

    static void approach2(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int[] nge = new int[arr.length];

        s.push(arr.length - 1);
        nge[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            // -a+
            while (s.size() > 0 && arr[i] >= arr[s.peek()]) {
                s.pop(); // -
            }
            if (s.size() == 0)
                nge[i] = -1;
            else
                nge[i] = arr[s.peek()]; // a
            s.push(i); // +
        }
        for (int i : nge) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
