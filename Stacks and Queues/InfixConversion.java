
/*package whatever //do not write package name here */
import java.io.*;
import java.util.*;

class InfixConversion {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String exp = br.readLine();
            Stack<Character> ops = new Stack<>();
            Stack<String> pre = new Stack<>();
            Stack<String> post = new Stack<>();
            Stack<Integer> val = new Stack<>();

            for (int i = 0; i < exp.length(); i++) {
                char ch = exp.charAt(i);
                if (ch == '(') {
                    ops.push(ch);
                } else if (ch == ')') {
                    while (ops.size() > 0 && ops.peek() != '(') {
                        processing(ops, val, pre, post);
                    }
                    ops.pop(); // opening bracket
                } else if ((ch >= '0' && ch <= '9') ||
                //  (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')
                 ) {
                    pre.push(ch + "");
                    post.push(ch + "");
                    val.push(ch - '0');
                } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                    while (ops.size() > 0 && ops.peek() != '(' && precedence(ch) <= precedence(ops.peek())) {
                        processing(ops, val, pre, post);
                    }
                    ops.push(ch);
                }

            }

            while (ops.size() > 0) {
                processing(ops, val, pre, post);
            }

            System.out.println(post.peek());
            System.out.println(pre.peek());
            System.out.println(val.peek());
        }
    }

    static void processing(Stack<Character> ops, Stack<Integer> val, Stack<String> pre, Stack<String> post) {
        char operator = ops.pop();
        // System.out.println("Operator is "+operator);
        String preval2 = pre.pop();
        String preval1 = pre.pop();
        String pre_eval = operator + preval1 + preval2;
        pre.push(pre_eval);

        String postval2 = post.pop();
        String postval1 = post.pop();
        String post_eval = postval1 + postval2 + operator;
        post.push(post_eval);

        int v2 = val.pop();
        int v1 = val.pop();
        int res = operation(v1, v2, operator);
        val.push(res);

    }

    static int operation(int val1, int val2, char ch) {
        if (ch == '+')
            return val1 + val2;
        else if (ch == '-')
            return val1 - val2;
        else if (ch == '*')
            return val1 * val2;
        else if (ch == '/')
            return val1 / val2;
        else
            return (val1 ^ val2);
    }

    static int precedence(char c) {
        if (c == '+' || c == '-')
            return 2;
        else if (c == '*' || c == '/')
            return 3;
        else if (c == '^')
            return 1;
        else
            return 0;
    }

}
