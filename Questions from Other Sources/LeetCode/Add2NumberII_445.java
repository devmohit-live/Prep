/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Add2NumberII_445 {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

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

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        // when reverse isn't allowed
        if (l1 == null || l2 == null)
            return l1 != null ? l1 : l2;
        int ll1 = length(l1);
        int ll2 = length(l2);
        int c = recursionAddition(l1, l2, ll1, ll2, result);
        if (c > 0) {
            addFirst(c);
        }

        return result;
    }

    private int recursionAddition(ListNode c1, ListNode c2, int pv1, int pv2, ListNode result) {
        int oc = 0;
        int data = 0;
        int nc = 0;
        if (pv1 == 0 && pv2 == 0) {
            return 0;
        } else if (pv1 > pv2) {
            // list1 is bigger in size
            oc = recursionAddition(c1.next, c2, pv1 - 1, pv2, result);
            data = oc + c1.val;
        } else if (pv2 > pv1) {
            // list2 is bigger in size
            oc = recursionAddition(c1, c2.next, pv1, pv2 - 1, result);
            data = oc + c2.val;
        } else {
            // go to minimum place value //lsb
            oc = recursionAddition(c1.next, c2.next, pv1 - 1, pv2 - 1, result);
            data = oc + c1.val + c2.val;
        }
        nc = data / 10;
        data = data % 10;
        // addFirst-> lsb addtion -> to -> msb addition => msb addition(last in
        // recursion) should appear at msb(first)
        addFirst(data);
        return nc;

    }

    private int length(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    private void addFirst(int data) {
        ListNode node = new ListNode(data);
        node.next = result;
        result = node;
    }

}