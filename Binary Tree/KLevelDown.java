public class KLevelDown {
    public static void printKLevelsDown(Node node, int k) {
        if (node == null)
            return;

        if (k == 0) {
            System.out.println(node.data);
        }

        printKLevelsDown(node.left, k - 1);
        printKLevelsDown(node.right, k - 1);
    }

    public static void main(String[] args) throws Exception {
        printKLevelsDown(root, k);
    }
}
