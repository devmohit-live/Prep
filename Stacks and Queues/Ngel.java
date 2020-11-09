import java.util.*;

/**
 * Next Greater elemnt to the left Just Itertare the array from right to left
 * the concept as well as code is same
 */

public class Ngel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int nge[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Stack<Integer> s = new Stack<>();
        s.push(n - 1); // pushing last index
        for (int i = n - 2; i >= 0; i--) {
            while (s.size() > 0 && a[i] >= a[s.peek()]) {
                int pos = s.peek();
                nge[pos] = a[i];
                s.pop();
            }
            s.push(i);
        }
        // elements left on the stack having no LEFT greater elements
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
