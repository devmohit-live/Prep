import java.util.*;

/**
 * Next Smaller elemnt to the right Just change the while's popping(and
 * answering) block condition from ge to le the concept as well as code is same
 */

public class Nser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int nse[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Stack<Integer> s = new Stack<>();
        s.push(0); // pushing first index
        for (int i = 1; i < n; i++) {
            while (s.size() > 0 && a[i] <= a[s.peek()]) {
                int pos = s.peek();
                nse[pos] = a[i];
                s.pop();
            }
            s.push(i);
        }
        // elements left on the stack having no right greater elements
        while (s.size() > 0) {
            nse[s.peek()] = -1;
            s.pop();
        }

        System.out.println();
        for (int i = 0; i < nse.length; i++) {
            System.out.print(nse[i] + " ");
        }
    }
}
