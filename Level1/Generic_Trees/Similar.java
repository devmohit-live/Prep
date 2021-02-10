public class Similar {
    // my solution
    public static boolean areSimilar(Node n1, Node n2) {
        int c1 = n1.children.size(), c2 = n2.children.size();
        if (c1 != c2)
            return false;
        // as we have already checked abpve that both have same no of children
        for (int i = 0; i < c1; i++) {
            Node a = n1.children.get(i);
            Node b = n2.children.get(i);
            boolean status = areSimilar(a, b);
            if (status == false)
                return false;
        }

        return true;
    }

    // my approach
    public static boolean areMirror(Node n1, Node n2) {
        // mirror any of them,now check wheater both have equal shape or not
        // say mirror n2
        mirror(n2);
        return areSimilar(n1, n2);

    }

    // without using previous functions
    // extremes of opposite sides are to be compares ex: tree 1 first child ===
    // tree2's last child
    public static boolean areMirror(Node n1, Node n2) {
        // no of children should be equal first
        if (n1.children.size() != n2.children.size())
            return false;

        // since we have checked no. of children are equal

        for (int i = 0; i < n1.children.size() - 1; i++) {
            int j = n2.children.size() - 1 - i; // getting last elemet //extreme from tree2
            boolean status = areMirror(n1.children.get(i), n2.children.get(j));
            if (status == false)
                return false;
        }

        return true;
    }

}
