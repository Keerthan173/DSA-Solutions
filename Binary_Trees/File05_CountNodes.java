public class File05_CountNodes {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static int countNodes(Node root) { 
        if (root == null) {
            return 0;  // Base case: no node to count
        }

        int lc = countNodes(root.left);   // Count nodes in left subtree
        int rc = countNodes(root.right);  // Count nodes in right subtree

        return lc + rc + 1;               // Total = left + right + root
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

        int totalCount = countNodes(root);
        System.out.println(totalCount); // 6
    }
}
/*
  Time Complexity: O(n)
  Space Complexity: O(h)

  https://leetcode.com/problems/count-complete-tree-nodes/
 */
