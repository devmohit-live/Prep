import java.io.*;
import java.util.*;

public class Main {
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

        Stack < Pair > st = new Stack < > ();
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

    public static void targetPair(Node root, Node node, int target) {
        if (node == null) return;

        //printing every pair in node
        targetPair(root, node.left, target);

        int comp = target - node.data;
        if (node.data < comp) {
            //ascending order
            boolean status = find(root, comp);
            if (status) {
                System.out.println(node.data + " " + comp);
            }
        }

        targetPair(root, node.right, target);

    }

    public static void targetPair2(Node node, int target) {
        ArrayList < Integer > res = new ArrayList < > ();
        traverse(node, res);

        int i = 0, j = res.size() - 1;
        while (i < j) {
            int sum = res.get(i) + res.get(j);
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                System.out.println(res.get(i) + " " + res.get(j));
                i++;
                j--;
            }
        }

    }

    private static void traverse(Node node, ArrayList < Integer > res) {
        if (node == null) return;

        traverse(node.left, res);
        res.add(node.data);
        traverse(node.right, res);
    }

    private static boolean find(Node node, int data) {
        if (node == null) return false;

        if (data < node.data) return find(node.left, data);
        else if (data > node.data) return find(node.right, data);
        else return true;
    }

    private static Node inorder(Stack<Pair> st){
        while(st.size()>0){
            Pair top = st.peek();
            
            if(top.state==0){
              if(top.node.left!=null) st.push(new Pair(top.node.left,0));
              top.state++;  
            }else if(top.state==1){
              if(top.node.right!=null) st.push(new Pair(top.node.right,0));
              top.state++;
              return top.node;
            }else{
                st.pop();
            }
            
        }
        return null;
    }
    
    private static Node inorderReverse(Stack<Pair> st){
        while(st.size()>0){
            Pair top = st.peek();
            
            if(top.state==0){
              if(top.node.right!=null) st.push(new Pair(top.node.right,0)); //right is pushed here instead of left
              top.state++;  
            }else if(top.state==1){
              if(top.node.left!=null) st.push(new Pair(top.node.left,0));
              top.state++;
              return top.node;
            }else{
                st.pop();
            }
            
        }
        return null;
    }
    
    
    public static void bestApproach(Node node,int target){
        Stack<Pair> ls=new Stack<>();
        Stack<Pair> rs=new Stack<>();
        
        ls.push(new Pair(node,0));
        rs.push(new Pair(node,0));
        
        Node left = inorder(ls);
        Node right = inorderReverse(rs);
        
        while(left.data < right.data){
            
            if(left.data + right.data < target){
                left = inorder(ls);
            }else if(left.data + right.data > target){
                right = inorderReverse(rs);
            }else{
                System.out.println(left.data + " "+ right.data);
                left = inorder(ls);
                right = inorderReverse(rs);
            }
            
        }
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

        int data = Integer.parseInt(br.readLine());

        Node root = construct(arr);

        // Time = O(nlogn), Space = O(logn)
        targetPair(root,root,data); 

        // Time = O(n), Space = O(n)
        targetPair2(root, data);

        // Time = O(n), Space = O(logn)
        bestApproach(root,data);
    }

}