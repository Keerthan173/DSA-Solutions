public class File02_Traversals  {
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
    static class BinaryTree {
        static int idx = -1;

        public Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);

            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }
    // Recursive Preorder Traversal: root → left → right
    static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");  // Visit root
        preOrder(root.left);                // Traverse left subtree
        preOrder(root.right);               // Traverse right subtree
    }

    // Recursive Inorder Traversal: left → root → right
    static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);                // Traverse left subtree
        System.out.print(root.data + " ");  // Visit root
        inOrder(root.right);               // Traverse right subtree
    }

    // Recursive Postorder Traversal: left → rigth → root
    static void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);                // Traverse left subtree
        postOrder(root.right);               // Traverse right subtree
        System.out.print(root.data + " ");  // Visit root
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

        preOrder(root); // 1 2 4 5 3 6 
        inOrder(root); // 4 2 5 1 3 6 
        postOrder(root); // 4 5 2 6 3 1
    }
}