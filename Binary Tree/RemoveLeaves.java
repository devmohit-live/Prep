public class RemoveLeaves {
    public static Node removeLeaves(Node node) {
        // base
        if (node == null)
            return null;

        // leaves => return null in place of itself(node)
        if (node.left == null && node.right == null)
            return null;

        // non leaves(return itself(node) after removing leaves) => if node is a leave
        // null will be returned else the value of node will be retunrned
        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);

        return node;
    }
}
