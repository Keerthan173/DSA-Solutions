public class File01_BuildTree {

    // Node class to represent each node in the binary tree
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // BinaryTree class with method to build the tree
    static class BinaryTree {
        static int idx = -1; // Static index to track position in array during recursion

        // Method to build binary tree from given preorder array
        public Node buildTree(int[] nodes) {
            idx++;

            // Base condition: if current element is -1, return null (no node)
            if (nodes[idx] == -1) {
                return null;
            }

            // Create a new node with current value
            Node newNode = new Node(nodes[idx]);

            // Recursively build left subtree
            newNode.left = buildTree(nodes);

            // Recursively build right subtree
            newNode.right = buildTree(nodes);

            return newNode; // Return the root of this subtree
        }
    }

    public static void main(String[] args) {
        // Preorder array: node, left, right; -1 represents null
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
            //      1
            //     / \
            //    2   3
            //   / \   \
            //  4   5   6


        // Create a BinaryTree instance and build the tree
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        // Print root node value to confirm tree is built
        System.out.println("Root of the Tree: " + root.data); // Root of the Tree: 1
    }
}