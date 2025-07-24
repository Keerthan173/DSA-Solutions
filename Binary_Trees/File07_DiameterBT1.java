public class File07_DiameterBT1 {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    // Height of a tree
    static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    // Diameter of Binary Tree
    public static int diameterBT(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDiam = diameterBT(root.left);     // Diameter of left subtree
        int rightDiam = diameterBT(root.right);   // Diameter of right subtree

        int lh = height(root.left);             // Height of left subtree
        int rh = height(root.right);            // Height of right subtree
        int diam = lh + rh + 1;                 // Diameter passing through current root

        return Math.max(diam, Math.max(leftDiam, rightDiam));
    }
    public static void main(String[] args) {
        //         1
        //       /   \
        //      2     3
        //     / \     \
        //    4   5     6
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Diameter of BT: " + diameterBT(root)); // 5
    }
}

/*
Time Complexity:
    Height is called for every node inside diameter, and height itself is O(n).
    So total time = O(n²)
 */