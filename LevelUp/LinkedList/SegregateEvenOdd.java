public class SegregateEvenOdd {
    
}

import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode even = new ListNode(-1);
        ListNode odd = new ListNode(-1);

        ListNode eventmp = even;
        ListNode oddtmp = odd;

        ListNode tmp = head;
        while (tmp != null) {
            if ((tmp.val & 1) == 1) {
                oddtmp.next = tmp;
                oddtmp = oddtmp.next;
            } else {
                eventmp.next = tmp;
                eventmp = eventmp.next;
            }
            tmp = tmp.next;
        }

        eventmp.next = odd.next; // attaching even and odd

        // v imp point to be noted
        // else in some cases leads to cycle creation(last odd element is still attached
        // to some even element) => ll ending at even number =>
        // 1,3,2,4,5,6,7,18,19,21,22,24

        oddtmp.next = null;
        return even.next;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}