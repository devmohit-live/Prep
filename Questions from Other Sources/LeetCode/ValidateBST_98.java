public class ValidateBST_98 {

    // Approach 1 storing the inorder and checking wheather it is sorted or not
    // Time and sapce O(N)
    ArrayList<Integer> order = new ArrayList<>();

    public boolean isValidBST1(TreeNode root) {
        inorder(root);

        for (int i = 0; i < order.size() - 1; i++) {
            if (order.get(i) >= order.get(i + 1))
                return false;
        }
        return true;

    }

    private void inorder1(TreeNode node) {
        if (node == null)
            return;
        inorder(node.left);
        order.add(node.val);
        inorder(node.right);
    }

    // Approach 2 : checking for >=(false condition in the recursion itself)
    // Time: O(n) space = constant
    // 100% faster than other

    // global variable
    TreeNode prev = null;

    public boolean isValidBST2(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode node) {

        if (node == null)
            return true;

        // left call
        boolean leftstatus = inorder(node.left);
        if (leftstatus == false)
            return false;

        // inorder work
        if (prev != null) {
            if (prev.val >= node.val)
                return false;
        }
        prev = node;

        // right call
        boolean rightstatus = inorder(node.right);
        if (rightstatus == false)
            return false;

        return true;
    }

    // Approach 3: Using min,max property of left and right node, creating separate
    // stucture
    // Time: O(N)

}

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
