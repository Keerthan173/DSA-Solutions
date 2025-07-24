import java.util.*;

public class File19_PrintAllPathSums {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    // Function to collect all valid paths that sum to target
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();

        dfs(root, targetSum, currentPath, result);

        return result;
    }

    // Helper function (DFS)
    public static void dfs(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) return;

        // Add current node to path
        currentPath.add(node.val);

        // If it's a leaf
        if(node.left == null && node.right == null){
            if(targetSum - node.val == 0){
                result.add(new ArrayList<>(currentPath)); // Add a copy
            }
        }else{
            // Continue DFS
            dfs(node.left, targetSum - node.val, currentPath, result);
            dfs(node.right, targetSum - node.val, currentPath, result);
        }

        // Backtrack
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        /*
                 5
               /   \
              4     8
             /     / \
            11    13  4
           /  \       \
          7    2       5

        Target Sum = 22
        Valid Paths:
        - 5→4→11→2
        - 5→8→4→5
        */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);

        int targetSum = 22;

        List<List<Integer>> paths = pathSum(root, targetSum);

        System.out.println("Paths with sum " + targetSum + ":");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
