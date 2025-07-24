public class File18_HasPathSum {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    // Function to check if path sum exists
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false; // Empty tree, no path
        }

        // If it's a leaf node, check if remaining sum equals node value
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }

        // Recur for left and right subtree with updated target
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        /*
                 5
               /   \
              4     8
             /     / \
            11    13  4
           /  \
          7    2

        Target Sum = 22
        Valid Path = 5 -> 4 -> 11 -> 2
        */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        int targetSum = 22;
        System.out.println("Has path sum? " + hasPathSum(root, targetSum)); // true
    }
}

/*
| Operation | Complexity                              |
| --------- | --------------------------------------- |
| Time      | O(n) – visit each node once             |
| Space     | O(h) – height of tree (recursion stack) |
*/