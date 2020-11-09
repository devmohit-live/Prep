public class Max_in_Tree {
    public static int maxVal(Node node) {
        int max = Integer.MIN_VALUE;
        for (Node child : node.children) {
            int cm = maxVal(child);
            max = Math.maxVal(max, cm);
        }
        max = Math.max(max, node.data);
        return max;
    }

    public static int height(Node node) {
        int ht = -1; // in terms of edges
        for (Node child : node.children) {
            int ch = height(child); // height of child
            ht = Math.max(ch, ht); // getting max_depth
        }

        ht += 1; // adding it's own egde difference(bw child and itself)
        return ht;
    }
}
