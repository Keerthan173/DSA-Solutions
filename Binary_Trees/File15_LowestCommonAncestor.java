// LeetCode: 236. Lowest Common Ancestor of a Binary Tree
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// Time Complexity: O(n)

public class File15_LowestCommonAncestor {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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

    // Main method to find LCA of two nodes in a binary tree
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if (p == q) return p; // same node case
        if (p == root || q == root) return root;

        boolean leftHasP = contains(root.left, p);
        boolean rightHasQ = contains(root.right, q);

        if (leftHasP && rightHasQ) return root;

        if (leftHasP && !rightHasQ) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (!leftHasP && rightHasQ) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root; // fallback
    }

    // Helper to check if a node exists in the subtree
    public static boolean contains(TreeNode root, TreeNode node) {
        if (root == null) return false;
        if (root == node) return true;

        return contains(root.left, node) || contains(root.right, node);
    }

    // Sample usage / testing
    public static void main(String[] args) {
        /*
                 3
               /   \
              5     1
             / \   / \
            6   2 0   8
               / \
              7   4

            LCA(5, 1) = 3
            LCA(6, 4) = 5
         */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode p = root.left; // 5
        TreeNode q = root.right; // 1

        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val); // LCA of 5 and 1 is: 3
    }
}
