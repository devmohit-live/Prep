import java.util.*;

/**
 * Here we check the plaindrome without suing recursion ie with O(1) space We
 * are findign mid node reversing the linkedlist from mid to last then comparing
 * 0 to mid and mid+1 to last after the comaprison and finding out list is
 * palindromic or not we are chaging the original list back to it's original
 * state Time: n + n/2 +n/2 + n/2 => 5n/2 => O(n)
 * 
 */

class Palindrome {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode c1 = head;

        ListNode mid = midofLL(head); // -> O(N)
        ListNode nhead = mid.next;
        // breaking the link
        mid.next = null;
        // reversing the second

        ListNode c2 = reverseLL(nhead); // -> O(n/2)

        boolean result = true;

        while (c1 != null && c2 != null) { // -> O(n/2)
            if (c1.val != c2.val) {
                result = false;
                break;
            }
            c1 = c1.next;
            c2 = c2.next;
        }

        // changing the orinal list back to it's real state
        // reversing back
        nhead = reverseLL(nhead); // -> o(n/2)
        // ading link
        mid.next = nhead;

        return result;
    }

    private static ListNode midofLL(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverseLL(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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
        System.out.println(isPalindrome(dummy.next));
        scn.close();
    }
}