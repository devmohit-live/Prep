class RemoveNthNodeFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        // there exists on;y 1 node and we wanted to remove that too
        if (head.next == null)
            return null;

        ListNode forward = head;
        ListNode node = head;

        // movinf n steps forwad
        while (n-- > 0) {
            forward = forward.next;
        }

        // reached end of the linkedlist => removing nth node from last = first node
        // from begining
        if (forward == null) {
            head = head.next;
            return head;
        }

        // forward.next!=null -> bcz we required k-1th/previos node to attach to k+1th
        // node
        // to get the node pointing to the n-1yh node not to nth node we stop 1 step
        // early that when fast.next=null
        while (forward != null && forward.next != null) {
            node = node.next;
            forward = forward.next;
        }

        // attaching k-1th node to k+1 th node after removing kth node
        node.next = node.next.next;

        return head;

    }
}