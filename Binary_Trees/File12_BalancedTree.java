/*
    Leetcode: Check if a binary tree is height-balanced
    https://leetcode.com/problems/balanced-binary-tree/
    A binary tree is balanced if for every node, the difference in height of
    left and right subtree is at most 1.
*/

public class File12_BalancedTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // Constructors
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        // Base case: An empty tree is balanced
        if (root == null) {
            return true;
        }

        // Calculate height of left and right subtrees
        int lh = height(root.left);
        int rh = height(root.right);

        // If height difference > 1, not balanced
        if (Math.abs(lh - rh) > 1) {
            return false;
        }

        // Check if left and right subtrees are also balanced
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return -1; // Using -1 makes height = number of edges (GFG style)
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }

    // Sample usage / testing
    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             /
            4
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), null);
        root.right = new TreeNode(3);

        System.out.println(isBalanced(root)); // Output: true
    }
}
