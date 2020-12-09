public

import java.io.*;
import java.util.*;

import sun.jvm.hotspot.tools.SysPropsDumper;

/**
 * INP: 19 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
 */
public class Traversals {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void traversal(Node node) {
        if (node == null)
            return;

        pre1.append(node.data + " ");
        traversal(node.left);
        in1.append(node.data + " ");
        traversal(node.right);
        post1.append(node.data + " ");

    }

    public static void levelOrder(Node node) {
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);

        while (mq.size() > 0) {
            int count = mq.size();

            for (int i = 0; i < count; i++) {
                node = mq.remove();
                System.out.print(node.data + " ");

                if (node.left != null) {
                    mq.add(node.left);
                }
                if (node.right != null) {
                    mq.add(node.right);
                }
            }

            System.out.println();
        }
    }

    public static void iterativePrePostInTraversal(Node node) {
        Stack<Pair> st=new Stack<>();
        st.push(new Pair(node,0));

        StringBuilder pre = new StringBuilder();
        StringBuilder in = new StringBuilder();
        StringBuilder post = new StringBuilder();

    while(st.size()>0)
    {
        Pair temp = st.peek();
        if (temp.state == 0) {
            pre.append(temp.node.data + " ");
            temp.state++;
            if (temp.node.left != null)
                st.push(new Pair(temp.node.left, 0)); // left addition after pre
        } else if (temp.state == 1) {
            in.append(temp.node.data + " ");
            temp.state++;
            if (temp.node.right != null)
                st.push(new Pair(temp.node.right, 0)); // right addition ater inorder
        } else {
            post.append(temp.node.data + " ");
            st.pop(); // clearing after post
        }
    }

    System.out.println(pre.toString());System.out.println(in.toString());System.out.println(post.toString());
 }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);
        traversal(root);
        System.out.println("Pre: " + pre1.toString());
        System.out.println("In: " + in1.toString());
        System.out.println("Post: " + post1.toString());
    }
    
    static StringBuilder pre = new StringBuilder();
    static StringBuilder in = new StringBuilder();
    static StringBuilder post = new StringBuilder();
    static StringBuilder pre1 = new StringBuilder();
    static StringBuilder in1 = new StringBuilder();
    static StringBuilder post1 = new StringBuilder();
}
