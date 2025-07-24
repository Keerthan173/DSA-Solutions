// Leetcode: 257. Binary Tree Paths
// https://leetcode.com/problems/binary-tree-paths/
// Given a binary tree, return all root-to-leaf paths as strings like "1->2->5"

import java.util.ArrayList;
import java.util.List;

public class File13_BinaryTreePaths {

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

    // Main method to get all paths from root to leaf
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(root, ans, "");
        return ans;
    }

    // Recursive helper method to build paths
    public static void helper(TreeNode root, List<String> ans, String str) {
        if (root == null) {
            return; // base case: empty node
        }

        // If it's a leaf node, add the path to list
        if (root.left == null && root.right == null) {
            str += root.val;
            ans.add(str);   // adds the completed path string to the list of results.
            return;
        }

        // Recurse on left and right with updated path
        helper(root.left, ans, str + root.val + "->");
        helper(root.right, ans, str + root.val + "->");
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
               \
                5
            Output: ["1->2->5", "1->3"]
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, null, new TreeNode(5));
        root.right = new TreeNode(3);

        List<String> result = binaryTreePaths(root);
        System.out.println(result); // [1->2->5, 1->3]
    }
}
