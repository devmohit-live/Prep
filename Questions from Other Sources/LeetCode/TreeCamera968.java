public class TreeCamera968 {
    // test cases

    // [0,0,null,0,0]
    // [0,0,null,0,null,0,null,null,0]

    /*
     * symbols:
     * 
     * 0 : present node installed camera on itself by seeing demand of child and
     * informed it's parent about it
     * 
     * 1 : present node says that it is being covered by a camera from one of it's
     * child
     * 
     * -1 : present node says that it is not being covered by any of it's child and
     * asked it's parent to install a camera to themself
     * 
     */

    // global
    int camera = 0;

    public int minCameraCover(TreeNode root) {
        // checking if root needs a camera?
        int rootval = checkCamera(root);
        if (rootval == -1)
            camera++;
        return camera;
    }

    public int checkCamera(TreeNode node) {
        if (node == null)
            return 1;

        int left = checkCamera(node.left);
        int right = checkCamera(node.right);

        if (left == -1 || right == -1) {
            camera++;
            return 0; // cameranode
        }
        if (left == 0 || right == 0) {
            return 1; // covered
        }
        // children are covered but I needed a camera
        return -1;
    }
}

// Definition for a binary tree node.
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

// camera node=0, covered=1, needed=-1