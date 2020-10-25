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
    }
}
