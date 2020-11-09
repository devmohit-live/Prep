import java.io.*;
import java.util.*;

// Diameter is max lengths going through a node it left child heigh + right child height +2(edges connectinf left and roght going through parent) 

public class Diameter_of_Tree {
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

    static int dia = 0;

    public static int height(Node node) {
        int height = -1;
        int second_height = -1;
        for (Node child : node.children) {
            int ch = height(child);
            if (ch > height) {
                second_height = height;
                height = ch;
            } else if (ch > second_height) {
                second_height = ch;
            }
        }
        int candidate = height + second_height + 2;
        // dia max heihgt of largest , sec largest +2

        if (candidate > dia)
            dia = candidate;

        return height + 1;
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
        height(root);
        System.out.println(dia);
    }

}