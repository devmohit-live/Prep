
public class KReverseUsingAddFirst {

    // Time: O(N)
    // space: O(1)
    ListNode oh = null;
    ListNode ot = null;
    ListNode th = null;
    ListNode tt = null;

    public ListNode reverseKGroup(ListNode head, int k) {
        // Time: n(length) + (n/k * k * 1(addFirst) ) => O(N)

        if (head == null || head.next == null || k == 0)
            return head;

        int l = length(head);
        ListNode curr = head;

        while (l >= k) { // O(n/k)
            int tempk = k;

            while (tempk-- > 0) { // O(k)
                ListNode next = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = next;
            }

            if (oh == null) {
                oh = th;
                ot = tt;
            } else {
                ot.next = th;
                ot = tt;
            }

            th = null;
            tt = null;
            l -= k;
        }
        // l<k
        ot.next = curr;
        return oh;

    }

    // O(n)
    int length(ListNode node) {
        ListNode tmp = node;
        int len = 0;
        while (tmp != null) {
            tmp = tmp.next;
            len++;
        }
        return len;
    }

    // O(1)
    void addFirst(ListNode node) {
        if (th == null) {
            th = node;
            tt = node;
        } else {
            node.next = th;
            th = node;
        }
    }
}

// Definition for singly-linked list.
class ListNode {
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
