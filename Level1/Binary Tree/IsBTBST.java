import java.io.*;
import java.util.*;

public class IsBTBST {
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

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        int th = Math.max(lh, rh) + 1;
        return th;
    }

    public static void traversalInorder(Node node, ArrayList<Integer> res) {
        if (node == null)
            return;
        traversalInorder(node.left, res);
        res.add(node.data);
        traversalInorder(node.right, res);
    }

    static class BSTPair {
        int min, max;
        boolean isBST;
    }

    public static BSTPair isTreeBST(Node node) {

        if (node == null) {
            BSTPair base = new BSTPair();
            base.min = Integer.MAX_VALUE;
            base.max = Integer.MIN_VALUE;
            base.isBST = true;
            return base;
        }

        BSTPair left = isTreeBST(node.left);
        BSTPair right = isTreeBST(node.right);

        // work done in postorder
        BSTPair mypair = new BSTPair();

        boolean isSubtreeBST = (left.isBST && right.isBST);
        boolean isNodeBST = (node.data >= left.max) && (node.data <= right.min);

        mypair.isBST = (isSubtreeBST && isNodeBST);

        mypair.min = Math.min(node.data, Math.min(left.min, right.min));
        mypair.max = Math.max(node.data, Math.max(left.max, right.max));

        return mypair;
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

        /* Approach 1 */
        ArrayList<Integer> res = new ArrayList<>();
        traversalInorder(root, res); // O(n)
        boolean status = true;
        // O(n)
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) > res.get(i + 1)) {
                status = false;
                break;
            }
        }
        // Time : O(2n)=>O(n)
        // Space : log(n)(recusion)+ O(n) arraylist => O(n)
        System.out.println("Approach 1: " + status);

        // Approach 2
        // Time : Visiting each node once =>O(n)
        // Space : log(n)(recusion stack storing BSTPair )=> O(logn)
        BSTPair rp = isTreeBST(root);
        System.out.println("Approach 2: " + rp.isBST);

        // time is same logn space is saved usign approach 2, runtime of apprach 1 is 2n

    }

}