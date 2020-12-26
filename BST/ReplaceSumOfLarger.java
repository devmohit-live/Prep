public class ReplaceSumOfLarger {

    static int sum = 0;

    public static void rwsol(Node node) {
        if (node == null)
            return;
        // right
        rwsol(node.right);
        // work
        int temp = node.data;
        node.data = sum;
        sum += temp;
        // left
        rwsol(node.left);
    }
}
