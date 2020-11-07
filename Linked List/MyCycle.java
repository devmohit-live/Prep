import java.util.HashMap;
import java.util.Scanner;

/**
 * This program is better if we have to find the first cycle (there exists
 * multiple cycle) Using this we can remove the cycle easily
 */
public class MyCycle {
    static class Node {
        int data;
        Node next;

        Node(int val) {
            this.data = val;
            this.next = null;
        }

        // Node() {
        // this.data = 0;
        // this.next = null;
        // }

        // Node(int val, Node next) {
        // this.data = val;
        // this.next = next;
        // }
    }

    static class LinkedList {
        Node head;
        Node tail;
        int size;
    }

    public static void cycleDetection() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = c; // cycle created
        // f.next = g;
        g.next = null;

        LinkedList ob = new LinkedList();
        ob.head = a;
        ob.tail = g;
        ob.size = 7;

        Node temp = ob.head;
        HashMap<Node, Node> h = new HashMap<>();
        Node status;
        Node node1 = null, node2 = null;
        while (true) { // old iteration was dependent on size which could be unknown //for (int i = 0;
                       // i < ob.size; i++)
            status = h.put(temp.next, temp);
            if (status != null) {
                // cycle detected
                node1 = status.next;
                node2 = h.get(temp.next);
                break;
            }
            temp = temp.next;
            if (temp == null) // in case no cycle is detected
                break;
        }
        if (node1 != null && node2 != null) {
            System.out.println("Cycle detected between " + node1.data + " and  " + node2.data);
            System.out.println("Breaking the Cycle Moving it's pointer to last node :");
            node2.next = ob.tail;
            // System.out.println("Give the node to which this node should be pointing ");
            // Scanner sc=new Scanner(System.in);
            // int v=
        }

        else
            System.out.println("No cycle found!!");
        display(ob);
    }

    public static void display(LinkedList ob) {
        Node temp = ob.head;
        while (temp.next != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        cycleDetection();
    }
}
