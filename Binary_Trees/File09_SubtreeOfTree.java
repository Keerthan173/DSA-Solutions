public class File09_SubtreeOfTree {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    // Main method to check if subRoot is a subtree of root
    public static boolean isSubtree(Node root, Node subRoot) {
        if (subRoot == null) return true;  // An empty tree is always a subtree
        if (root == null) return false;    // Can't find match if main tree is empty

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        // Check in left or right subtree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Helper method to check if two trees are identical
    public static boolean isIdentical(Node node, Node subNode) {
        
        // Both are null → trees are identical at this branch
        if (node == null && subNode == null) {
            return true;
        }

        // One is null or data mismatch → not identical
        if (node == null || subNode == null || node.data != subNode.data) {
            return false;
        }

        // Recursively check left and right subtrees
        return isIdentical(node.left, subNode.left) && isIdentical(node.right, subNode.right);
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

        //      2
        //     / \
        //    4   5 
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubtree(root, subRoot)); // true
    }
}

// Time Complexity:
// O(m * n) in worst case
// where m = number of nodes in root, n = number of nodes in subRoot.