/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Add2NumberII_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null)
            return l1 != null ? l1 : l2;

        ListNode result = new ListNode(-1);
        ListNode tmp = result;
        ListNode c1 = reverse(l1);
        ListNode c2 = reverse(l2);

        int carry = 0;
        while (c1 != null || c2 != null || carry != 0) {
            int digit = carry;
            if (c1 != null) {
                digit += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                digit += c2.val;
                c2 = c2.next;
            }
            carry = digit / 10;
            digit = digit % 10;
            tmp.next = new ListNode(digit);
            tmp = tmp.next;
        }
        return reverse(result.next);
    }

    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null)
            return node;

        ListNode prev = null;
        ListNode curr = node;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }

}