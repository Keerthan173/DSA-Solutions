public class File14_KthLevel {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    // Print all nodes at the K-th level of a binary tree
    static void kthLevel(Node root, int k, int level) {
        if (root == null) return; // base case

        if (level == k) {
            System.out.print(root.data + " "); // reached target level
            return;     // avoids going to level k+1, k+2, etc.
        }

        // Recurse left and right with incremented level
        kthLevel(root.left, k, level + 1);
        kthLevel(root.right, k, level + 1);
    }
    public static void main(String[] args) {
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int k = 2;
        kthLevel(root, k, 1); // 2 3
    }
}