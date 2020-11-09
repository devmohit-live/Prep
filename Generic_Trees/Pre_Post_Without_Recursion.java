import java.io.*;
import java.util.*;

public class Pre_Post_Without_Recursion {
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

    // Pair to save node with a variable state that helps us to acheive recursion
    // using stack
    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void IterativePreandPostOrder(Node node) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, -1)); // root
        String pre = "";
        String post = "";
        while (st.size() > 0) {
            Pair temp = st.peek();

            // if not visited just added state= -1
            if (temp.state == -1) {
                pre += temp.node.data + " ";
                temp.state++; // incrementing state for next possible child
            } else if (temp.state == temp.node.children.size()) {
                // if all child are visited=> state =children.size
                post += temp.node.data + " ";
                st.pop();
            } else {
                // visiting children
                Pair child = new Pair(temp.node.children.get(temp.state), -1); // getting each children as state = 0->
                                                                               // children.size -1 =>
                st.push(child);
                temp.state++; // incrementing state for next possible child
            }
        }
        System.out.println(pre);
        System.out.println(post);
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
        IterativePreandPostOrder(root);
    }

}