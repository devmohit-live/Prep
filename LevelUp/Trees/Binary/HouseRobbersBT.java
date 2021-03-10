public class HouseRobbersBT {

    // LeetCode 337
    class HousePair {
        int with_self_robbery;
        int without_self_robbery;
    }

    public int rob(TreeNode root) {
        HousePair result = robbery(root);
        return Math.max(result.with_self_robbery, result.without_self_robbery);
    }

    public int robWithoutClass(TreeNode root) {
        int[] result = robberyWithoutClass(root);
        return Math.max(result[0], result[1]);
    }

    private HousePair robbery(TreeNode node) {
        if (node == null)
            return new HousePair();

        HousePair left = robbery(node.left);
        HousePair right = robbery(node.right);

        HousePair ans = new HousePair();
        // if robbing the current house so robbing the adjacent wouldn't be allowed
        ans.with_self_robbery = left.without_self_robbery + node.val + right.without_self_robbery;
        // if not robbing the current house, then get the maximum amount that can be
        // obtained from left as well as from right child

        // max amout from left.right child can be in any of the case 1. if that house is
        // robbed or 2. that house isn't robbed but it's children houses are robbed we
        // will be taking the max
        ans.without_self_robbery = Math.max(left.without_self_robbery, left.with_self_robbery)
                + Math.max(right.without_self_robbery, right.with_self_robbery);

        return ans;
    }

    // 0:with_self_robbery 1:without_self_robbery
    private int[] robberyWithoutClass(TreeNode node) {
        if (node == null)
            return new int[2];

        int[] left = robberyWithoutClass(node.left);
        int[] right = robberyWithoutClass(node.right);

        int[] ans = new int[2];
        // if robbing the current house so robbing the adjacent wouldn't be allowed
        ans[0] = left[1] + node.val + right[1];
        // if not robbing the current house, then get the maximum amount that can be
        // obtained from left as well as from right child

        // max amout from left.right child can be in any of the case 1. if that house is
        // robbed or 2. that house isn't robbed but it's children houses are robbed we
        // will be taking the max
        ans[1] = Math.max(left[1], left[0]) + Math.max(right[1], right[0]);

        return ans;
    }

}
