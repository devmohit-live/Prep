public class Tree_Traversals {
    public static void traversals(Node node) {
        if (node == null)
            return;
        System.out.println("Node Pre " + node.data);
        for (Node child : node.children) {
            System.out.println("Edge Pre " + node.data + "--" + child.data);
            traversals(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);

        }
        System.out.println("Node Post " + node.data);
    }

    public static void levelOrder(Node node) {
        // rpa -> remove print add
        Queue<Node> q = new ArrayDeque<>(); // all the level2 nodes will only come after all the level1
        // if we do it with recursion then level n+1 nodes will comed before level n ,
        // also some parent nodes will get repeated
        q.add(node); // root added

        while (q.size() > 0) {
            Node temp = q.remove();
            System.out.print(temp.data + " ");
            // add children in queue -.(maintains level order)
            for (Node child : temp.children) {
                q.add(child);
            }
        }
        System.out.print(".");
    }

    public static void levelOrderLinewise(Node node) {
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node); // root
        Queue<Node> cq = new ArrayDeque<>(); // child queue stores the child of each elements in the upper level
                                             // siblings of each other
        while (mq.size() > 0) {
            Node temp = mq.remove();
            System.out.print(temp.data + " ");

            for (Node child : temp.children) {
                cq.add(child);
            }

            if (mq.size() == 0) {
                System.out.println(); // new line -> level is completed
                mq = cq;
                cq = new ArrayDeque<Node>();
            }
        }

    }

    // using marker node that detects change in level
    public static void levelOrderLinewise2(Node node) {
        // marker approach using a Node to detect level change
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node); // root
        mq.add(new Node(Integer.MIN_VALUE)); // marker
        // using -inf as marker as null isn't supported in Q
        while (mq.size() > 0) {
            Node temp = mq.remove();
            if (temp.data != Integer.MIN_VALUE) {
                System.out.print(temp.data + " ");
                for (Node child : temp.children) {
                    mq.add(child);
                }

            } else {
                if (mq.size() > 0) {
                    mq.add(new Node(Integer.MIN_VALUE));
                    System.out.println();
                }

            }
        }

    }

    // using level currentsize of main queue
    public static void levelOrderLinewise3(Node node) {
        // using current size of q as an detection
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node); // root
        while (mq.size() > 0) {
            int csoq = mq.size(); // storing the current q size
            for (int i = 0; i < csoq; i++) {
                // rp
                Node temp = mq.remove();
                System.out.print(temp.data + " ");
                // a
                for (Node child : temp.children) {
                    mq.add(child);
                }
            }
            System.out.println();
        }
    }

    // using Pair of node and it's level
    // creating new Pair class
    private static class Pair {
        Node node;
        int level;

        Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    // implementation
    public static void levelOrderLinewise4(Node node) {
        // using Pair of node-level
        Queue<Pair> mq = new ArrayDeque<>();
        int level = 1;
        mq.add(new Pair(node, level)); // root

        while (mq.size() > 0) {
            // r
            Pair temp = mq.remove();

            if (temp.level > level) {
                System.out.println();
                level = temp.level;
            }
            System.out.print(temp.node.data + " "); // p
            // a
            for (Node child : temp.node.children) {
                mq.add(new Pair(child, temp.level + 1));
            }
        }

    }

    public static void levelOrderLinewiseZZ(Node node) {
        Node temp = null;
        int level = 1;
        Stack<Node> ms = new Stack<>();
        ms.push(node); // root
        Stack<Node> cs = new Stack<>();

        while (ms.size() > 0) {
            temp = ms.pop();
            System.out.print(temp.data + " ");
            // adding schildren in stack in the fashion so that zigzag pattern is obtained
            if ((level & 1) == 1) {
                for (int i = 0; i < temp.children.size(); i++) {
                    Node t = temp.children.get(i);
                    cs.push(t);
                }
            } else {
                for (int i = temp.children.size() - 1; i >= 0; i--) {
                    Node t = temp.children.get(i);
                    cs.push(t);
                }
            }

            if (ms.size() == 0) {
                System.out.println();
                ms = cs;
                cs = new Stack<Node>();
                level++;
            }
        }

    }

    public static void levelOrderLinewise2(Node node) {
        // marker approach using a Node to detect level change
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node); // root
        mq.add(new Node(Integer.MIN_VALUE)); // marker
        // using -inf as marker as null isn't supported in Q
        while (mq.size() > 0) {
            Node temp = mq.remove();
            if (temp.data != Integer.MIN_VALUE) {
                System.out.print(temp.data + " ");
                for (Node child : temp.children) {
                    mq.add(child);
                }

            } else {
                if (mq.size() > 0) {
                    mq.add(new Node(Integer.MIN_VALUE));
                    System.out.println();
                }

            }
        }

    }

}
