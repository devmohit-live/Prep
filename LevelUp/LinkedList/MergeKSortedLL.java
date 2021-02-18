import java.util.*;

class MergeKSortedLL {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Approach 1 : Using devide and Conquer

    // Approach 2
    // Using PQ : Time: NKlogk + NKlogk => O(NKlogk)

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) { // O(N)
            ListNode itr = lists[i];
            while (itr != null) { // O(K)
                pq.add(itr.val); // log k
                itr = itr.next;
            }
        }

        while (!pq.isEmpty()) { // O(NK)
            // ListNode
            tmp.next = new ListNode(pq.remove()); // log K
            tmp = tmp.next;
        }

        return dummy.next;
    }

    // Using PQ of ListNodes(manipulation with pointers too)

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode[] list = new ListNode[n];
        for (int i = 0; i < n; i++) {
            int m = scn.nextInt();
            list[i] = createList(m);
        }

        ListNode head = mergeKLists(list);
        printList(head);
    }
}