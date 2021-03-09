public class DetectCycle_141 {
    // LeetCode : 141 => Only detects cycle doesn't removes it
    // Using HashMap
    // time, space: O(N)
    // slower runtime
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        HashMap<ListNode, ListNode> map = new HashMap<>();
        ListNode tmp = head;
        while (tmp != null) {
            ListNode a = tmp;
            ListNode b = tmp.next;
            // if someone's value matches to key
            if (map.containsKey(b)) {
                return true;
            } else {
                map.put(a, b);
            }

            tmp = tmp.next;
        }
        return false;
    }

    // tortoise and hare approah
    // Time : O(N)
    // Space: constant
    // better runtime
    public boolean hasCycleEfficient(ListNode head) {

        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != null && fast.next != null && fast.next.next != null) {

            if (fast == slow)
                return true;

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

}
