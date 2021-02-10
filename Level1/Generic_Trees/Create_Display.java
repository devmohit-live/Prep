import java.util.ArrayList;
import java.util.Stack;

public class Create_Display {

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    private static void create(int arr[]) {
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                // pop
                st.pop();
            } else {
                // create node make it someone's child and push to stack
                Node temp = new Node();
                temp.data = arr[i];
                if (st.size() > 0) {
                    st.peek().children.add(temp);
                } else {
                    root = temp;
                }
                st.push(temp);
            }
        }
    }

    private static void display(Node node) {
        if (node == null)
            return;
        // self
        System.out.print(node.data + " ->  ");
        for (Node child : node.children) {
            System.out.print(child.data + ", ");
        }
        System.out.println(".");

        // childe invoke calls
        for (Node child : node.children) {
            display(child);
        }
    }

    static Node root;

    public static void main(String[] args) {
        int arr[] = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1, };
        create(arr);
        display(root);
    }
}
