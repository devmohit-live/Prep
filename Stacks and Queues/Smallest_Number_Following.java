import java.io.*;
import java.util.*;

public class Smallest_Number_Following {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Integer> st = new Stack<>();
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'd') {
                st.push(count);
            } else {
                System.out.print(count);
                while (!st.isEmpty()) {
                    System.out.print(st.pop());
                }
            }
            count++;
        }
        st.push(count); // appending the last count(n+1)th
        while (!st.isEmpty())
            System.out.print(st.pop()); // n+1 th count(end) and rest of the stack elements left
        // as in case of dddd or ending with d there is no breakpoint to pop
    }

}