public class Cycle {
    static class Node {
        int data;
        Node next;

        Node(int val) {
            this.data = val;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;
        Node tail;
        int size;
    }

    // detect cycle
    static Node detect(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return slow; //
        }
        return null;
    }

    static Node startPoint(Node head) {
        if (head == null || head.next == null)
            return null; // empty, single node can't have cycle
        Node meetpoint = detect(head);
        if (meetpoint == null)
            return null; // no cycle detected
        Node temp = head;
        while (temp != meetpoint) {
            temp = temp.next;
            meetpoint = meetpoint.next;
        }
        return temp;
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

        Node res = startPoint(ob.head);
        System.out.println("Starting of cycle is at : " + res.data);
        // display(ob);

    }
}
