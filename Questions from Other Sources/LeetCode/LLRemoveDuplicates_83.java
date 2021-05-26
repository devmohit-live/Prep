class LLRemoveDuplicates_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode itr = head;
        ListNode node = itr.next;
        ListNode prev = itr;

        while (node != null) {
            if (itr.val != node.val) {
                prev.next = null;
                itr.next = node;
                itr = itr.next;
            }
            prev = node;
            node = node.next;
        }
        // edge cases to avoid extra duplicates at end
        itr.next = null;
        return head;
    }
}