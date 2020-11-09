import java.io.*;
import java.util.*;

public class Max_Sum_Subtree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    static int msst_node = 0;
    static int msst_sum = Integer.MIN_VALUE;

    static int sum_subtree(Node node) {
        int sum = 0;
        for (Node child : node.children) {
            int cs = sum_subtree(child);
            sum += cs;
        }
        sum += node.data;

        if (sum > msst_sum) {
            msst_sum = sum;
            msst_node = node.data;
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        sum_subtree(root); // returns sum of subtrees at each level
        // but in the process we calculated the maxsum in between =>
        // recursion returns something else but we put some of our codes/candisates to
        // capture desired situations result
        System.out.println(msst_node + "@" + msst_sum);
    }

}