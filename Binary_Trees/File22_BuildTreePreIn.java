// onstructing a binary tree from preorder and inorder traversal 
// (Leetcode 105) 
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

import java.util.*;

public class File22_BuildTreePreIn {
    // Binary Tree Node class
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Solution class
    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // Map value → index from inorder[]
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return helper(preorder, 0, preorder.length - 1,
                          inorder, 0, inorder.length - 1, map);
        }

        private TreeNode helper(int[] preorder, int preStart, int preEnd,
                                int[] inorder, int inStart, int inEnd,
                                HashMap<Integer, Integer> map) {
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }

            // Root node from preorder
            TreeNode root = new TreeNode(preorder[preStart]);

            // Root's index in inorder
            int inRootIdx = map.get(root.val);

            // Number of nodes in left subtree
            int leftLen = inRootIdx - inStart;

            // Build left and right subtrees
            root.left = helper(preorder, preStart + 1, preStart + leftLen,
                            inorder, inStart, inRootIdx - 1, map);

            root.right = helper(preorder, preStart + leftLen + 1, preEnd,
                                inorder, inRootIdx + 1, inEnd, map);

            return root;
        }
    }

    // Print Inorder to verify the tree
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // Main method to test the solution
    public static void main(String[] args) {
        /*
              3
             / \
            9  20
               / \
              15  7

            preorder = [3,9,20,15,7]
            inorder  = [9,3,15,20,7]
         */

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        Solution sol = new Solution();
        TreeNode root = sol.buildTree(preorder, inorder);

        System.out.print("Inorder of constructed tree: ");
        printInorder(root);  //  9 3 15 20 7 (Output should match inorder array)
    }
}
