
import java.util.*;

/**
 * Here we have to create a deep copy of a LinkedList LeetCode 138
 */
public class CopyListWithRandomPointer {
    // Time:O(N),space:O(N)
    public static Node copyRandomList(Node head) {
        Node newhead = new Node(-1);
        Node cp = newhead;
        Node tmp = head;
        // old ll node: new ll node
        Map<Node, Node> map = new HashMap<>();
        while (tmp != null) {
            Node n = new Node(tmp.val);
            map.put(tmp, n);
            cp.next = n;
            cp = cp.next;
            tmp = tmp.next;
        }

        tmp = head;
        cp = newhead.next;

        while (tmp != null) {
            Node random = tmp.random;
            // System.out.println(random + " " + map.get(random));
            // map.get(null)=> null , so null cases is handled automatically eyt you can
            // write an extra if case for it
            Node pointingto = map.get(random);
            cp.random = pointingto;

            tmp = tmp.next;
            cp = cp.next;
        }

        return newhead.next;
    }

    // Time: O(n*n), fails in certain deep copy cases
    /**
     * Fails Here:
     * [[3,null],[5,17],[4,null],[-9,6],[-10,3],[5,15],[0,11],[6,null],[-6,16],[3,16],[-6,11],[9,12],[-2,1],[-3,11],[-1,10],[2,11],[-3,null],[-9,7],[-2,4],[-8,null],[5,null]]
     * 
     * Expected:
     * [[3,null],[5,17],[4,null],[-9,6],[-10,3],[5,15],[0,11],[6,null],[-6,16],[3,16],[-6,11],[9,12],[-2,1],[-3,11],[-1,10],[2,11],[-3,null],[-9,7],[-2,4],[-8,null],[5,null]]
     * 
     * Actual:
     * [[3,null],[5,3],[4,null],[-9,6],[-10,3],[5,15],[0,11],[6,null],[-6,13],[3,13],[-6,11],[9,12],[-2,1],[-3,11],[-1,8],[2,11],[-3,null],[-9,7],[-2,4],[-8,null],[5,null]]
     */
    public Node copyRandomListNaive(Node head) {
        Node newhead = new Node(-1);
        Node cp = newhead;
        Node tmp = head;
        while (tmp != null) {
            Node n = new Node(tmp.val);

            cp.next = n;
            cp = cp.next;
            tmp = tmp.next;
        }

        tmp = head;
        cp = newhead.next;
        Node copy = newhead.next;

        while (tmp != null) {
            Node random = tmp.random;
            Node itr = copy;
            while (true) {
                if (random == null) {
                    cp.random = null;
                    break;
                }

                if (random.val == itr.val) {
                    cp.random = itr;
                    break;
                } else {
                    itr = itr.next;
                }
            }
            tmp = tmp.next;
            cp = cp.next;
        }

        return newhead.next;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        Node[] arr = new Node[n];
        Node prev = null;

        for (int i = 0; i < n; i++) {
            arr[i] = new Node(0);
            if (prev != null)
                prev.next = arr[i];
            prev = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            int idx = scn.nextInt();

            arr[i].val = val;
            if (idx != -1)
                arr[i].random = arr[idx];
        }

        Node head = copyRandomList(arr[0]);
        while (head != null) {
            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
            head = head.next;
        }
    }
}

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
