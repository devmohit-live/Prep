public class Find {
    public static boolean find(Node node, int data) {
        if (node.data == data)
            return true;
        for (Node child : node.children) {
            if (child.data == data) {
                return true; // not compulsory as first line in recursion handles it, but I think it can save
                             // various calls
            }
            boolean status = find(child, data);
            if (status == true)
                return true;
        }
        return false;
    }
}
