public class File16_InvertBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Function to invert the tree 
    // public static TreeNode invertTree(TreeNode root) {
    //     if(root == null){
    //         return null;
    //     }
    //     TreeNode lst = root.left;
    //     TreeNode rst = root.right;

    //     root.left = rst;
    //     root.right = lst;

    //     invertTree(root.left);
    //     invertTree(root.right);

    //     return root;
    // }
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Swap left and right
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    // Inorder traversal to check result
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        /*
               1
              / \
             2   3
            / \   \
           4   5   6

        After invert:
               1
              / \
             3   2
            /   / \
           6   5   4
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.print("Before Invert (Inorder): ");
        printInorder(root); // 4 2 5 1 3 6
        System.out.println();

        invertTree(root); // Invert the tree

        System.out.print("After Invert (Inorder): ");
        printInorder(root); // 6 3 1 5 2 4
        System.out.println();
    }
}


/* 
Time & Space Complexity:
    Time: O(n) → Each node visited once
    Space: O(h) → Recursion stack (height of tree)
*/
