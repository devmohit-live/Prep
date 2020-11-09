public class Find {
    public static boolean find(Node node, int data) {
        if (node.data == data)
            return true;
        for (Node child : node.children) {
            boolean status = find(child, data);
            if (status == true)
                return true;
        }
        return false;
    }
}
