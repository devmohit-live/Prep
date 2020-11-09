class LinearizeTree {
    // O(N*N)
    public static void linearize(Node node) {
        for (Node child : node.children) {
            linearize(child);
        }

        // linking
        while (node.children.size() > 1) {
            Node lc = node.children.get(node.children.size() - 1);
            Node slc = node.children.get(node.children.size() - 1);
            Node sctail = getTail(slc);
            sctail.children.add(lc);
        }
    }

    private static Node getTail(Node node) {
        while (node.children.size() == 1) {
            node = node.children.get(0);
        }
        return node;
    }

}

public class LinearizeTree_InPreOrder extends LinearizeTree {
    // O(N)
    public static Node linearize(Node node) {
        if (node.children.size() == 0)
            return node;

        Node lkt = linearize(node.children.get(node.children.size() - 1)); // linearizinf and gettign the last node key
                                                                           // to chain the second last
        while (node.children.size() > 1) {
            Node last = node.children.remove(node.children.size() - 1); // removing the last child along woth children
                                                                        // for linkeage (already linearized)
            Node slast = node.children.get(node.children.size() - 1); // getting the second last child
            Node sklt = linearize(slast); // linearizing the sl child and also getting it's tail for the linking process
            sklt.children.add(last); // linking them
        }

        return lkt; // only one left after the loop
    }
}