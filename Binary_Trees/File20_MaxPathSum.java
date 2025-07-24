// Leetcode 124: https://leetcode.com/problems/binary-tree-maximum-path-sum/
// Return the maximum path sum from any node to any node

public class File20_MaxPathSum {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    static class Solution {
        int maxSum = Integer.MIN_VALUE; // To store the maximum path sum globally

        public int maxPathSum(TreeNode root) {
            helper(root);
            return maxSum;
        }

        // Helper function to calculate max gain from each node
        private int helper(TreeNode root) {
            if (root == null) return 0;

            // Calculate max path on left and right; ignore negative paths
            int left = Math.max(0, helper(root.left));
            int right = Math.max(0, helper(root.right));

            // Check if the path through this node is maximum
            int localMax = root.val + left + right;

            // Update global max if this path is better
            maxSum = Math.max(maxSum, localMax);

            // Return max path including current node and one child
            return root.val + Math.max(left, right);
        }
    }

    public static void main(String[] args) {
        /*
                -10
                /  \
               9   20
                  /  \
                 15   7

            Output: 42 (15 + 20 + 7)
        */

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution sol = new Solution();
        int maxPath = sol.maxPathSum(root);
        System.out.println("Maximum Path Sum: " + maxPath); // 42
    }
}
