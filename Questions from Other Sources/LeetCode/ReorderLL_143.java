public class ReorderLL_143 {
    // simply fold a ll
    // leetcode: 143
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    // Time: O(n + n/2 +n/2)=> O(n),
    // space: O(1)

    public void reorderList1(ListNode head) {
        // Approach1: Using mid and reversing from mid approach
        if (head == null || head.next == null)
            return;
        ListNode tmp = head;
        ListNode mid = midOfLL(tmp);
        ListNode newhead = mid.next;
        // breaking the bond bw mid and mid+1
        mid.next = null;

        newhead = reverseLL(newhead);
        ListNode cpnewhead = newhead;
        while (cpnewhead != null) {
            ListNode nexttmp = tmp.next;
            ListNode nextcphead = cpnewhead.next;

            tmp.next = cpnewhead;
            cpnewhead.next = nexttmp;

            tmp = nexttmp;
            cpnewhead = nextcphead;
        }

    }

    private ListNode midOfLL(ListNode node) {

        ListNode slow = node;
        ListNode fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseLL(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Approach 2 using recursion stack for right pointer
    // time: O(n(length) + n(recursion)) => O(N)
    // space: O(n) recursion stack
    ListNode left = null;
    int floor = 0;

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        floor = length(head) / 2;
        left = head;
        recurseHelper(head);

    }

    private void recurseHelper(ListNode node) {
        if (node == null)
            return;

        recurseHelper(node.next);

        if (floor > 0) {
            ListNode lnext = left.next;
            left.next = node;
            node.next = lnext;
            left = lnext;
            floor--;
        }

        if (floor == 0) {
            // last node's next should be null else cycle will be formed
            left.next = null;
        }

    }

    private int length(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

}
