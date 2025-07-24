public class File17_SymmetricBT {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    // Function to check if tree is symmetric
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    // Helper function to compare two subtrees
    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;  // Both null => symmetric
        if (t1 == null || t2 == null) return false; // One is null => not symmetric
        if (t1.val != t2.val) return false;         // Mismatched values

        // Mirror condition: outer and inner sides should match
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   2
             / \ / \
            3  4 4  3   => symmetric

        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("Is symmetric? " + isSymmetric(root)); // true
    }
}