import java.io.*;
import java.util.*;

public class BST {
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

    public static Node construct(int[] arr,int low,int high) {
        // if(node == null) return null;
        if(low<0 || high >=arr.length || low>high) return null;
        
        int mid = (low+high)/2;
        Node root = new Node(arr[mid],null,null);
        root.left = construct(arr,low,mid-1);
        root.right = construct(arr,mid+1,high);
        
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

    public static void main(String[] args) throws Exception {
    // int[] arr= {12,13,14,15,16,20,24,25,26,28,30};
    int[] arr= {12,25,37,50,62,75,87};
    Node root = construct(arr,0,arr.length-1);
    display(root);
    
    }

}