public class Add2NumerLL_2_Reve {
    // LeetCode : 2

    // NOTE: here the linkedlist is given in reverseorder ie a numer 123 => 321
    // the anser to be given is also in the reversed order
    // to solve question if the order was given in correct placevalues
    // format(normal) and answer was also in the normal format use pepco method

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode(-1);
        ListNode tmp = res;

        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            int data = sum % 10;
            ListNode node = new ListNode(data);
            tmp.next = node;
            tmp = tmp.next;
        }
        return res.next;

    }
}
