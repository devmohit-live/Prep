public class Arithmatic_Adiition_LL {
    private static int addHelper(Node one, int pv1, Node two, int pv2, LinkedList res) {
        if (one == null && two == null) {
            return 0;
        }

        int data = 0;
        if (pv1 > pv2) {
            // list one is empty
            int c = addHelper(one.next, pv1 - 1, two, pv2, res);
            data = one.data + c;
        } else if (pv2 > pv1) {
            // list two is empty
            int c = addHelper(one, pv1, two.next, pv2 - 1, res);
            data = two.data + c;

        } else {
            int c = addHelper(one.next, pv1 - 1, two.next, pv2 - 1, res);
            data = one.data + two.data + c;
        }
        int ndata = data % 10;
        int nc = data / 10;
        res.addFirst(ndata);
        return nc;

    }

    public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
        LinkedList res = new LinkedList();
        int carry = addHelper(one.head, one.size, two.head, two.size, res);
        if (carry > 0) {
            res.addFirst(carry);
        }
        return res;
    }
}