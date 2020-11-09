public class NodeToRootPath {
    /**
     * acts as the base for lowest common ancestor, distance between two nodes
     */
    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList<Integer> ptr = new ArrayList<>();
            ptr.add(data);
            return ptr;
        }
        for (Node child : node.children) {
            ArrayList<Integer> path_till_child = nodeToRootPath(child, data);
            if (path_till_child.size() > 0) {
                path_till_child.add(node.data); // bcz we have found the data from our children and we are returning
                                                // something from our behalf ie, we should return true => our data not
                                                // child
                return path_till_child;
            }
        }

        return new ArrayList<Integer>();
    }
}
