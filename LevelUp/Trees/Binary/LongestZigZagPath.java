public class LongestZigZagPath {

    public int longestZigZag(TreeNode root) {
        return longestZigZag_(root).maxlen;
    }

    public Pair longestZigZag_(TreeNode node) {

        if (node == null)
            return new Pair();
        Pair left = longestZigZag_(node.left);
        Pair right = longestZigZag_(node.right);

        Pair ans = new Pair();
        // left se backward attach rahega aage ka
        int including_current_node_as_start = Math.max(left.backward_direction, right.forward_direction) + 1;
        int longest_somewhere_in_subtree = Math.max(left.maxlen, right.maxlen);
        ans.maxlen = Math.max(longest_somewhere_in_subtree, including_current_node_as_start);

        ans.forward_direction = left.backward_direction + 1;
        ans.backward_direction = right.forward_direction + 1;

        return ans;

    }
}

class Pair {
    // edge based
    int forward_direction = -1;
    int backward_direction = -1;
    int maxlen = 0;
}
