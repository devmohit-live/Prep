import java.util.*;

/**
 * Next Smaller elemnt to the left ->Just change the iteration direction and
 * initialization of nser
 * 
 * OR
 */

public class Nsel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int nse[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Stack<Integer> s = new Stack<>();
        s.push(n - 1); // pushing first index
        for (int i = n - 1; i >= 0; i--) {
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
