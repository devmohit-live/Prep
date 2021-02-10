public class Remove_Leaves {
    public static void removeLeaves(Node node) {
        /**
         * foreach won't work as we get concurrent modification error running the loop
         * from i= 0->size will have logical error as some elements are skipped(after
         * removal all elemets are shifted toward left and i keeps on increasing)
         */

        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if (child.children.size() == 0) {
                node.children.remove(node.children.get(i));
            }
        }

        for (Node child : node.children) {
            removeLeaves(child);
        }

    }
}
