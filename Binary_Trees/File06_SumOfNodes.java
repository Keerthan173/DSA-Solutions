public class File06_SumOfNodes {
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

    public static int sum(Node root) { 
        if (root == null) {
            return 0;
        }

        int ls = sum(root.left);   // Sum in left subtree
        int rs = sum(root.right);  // Sum in right subtree

        return ls + rs + root.data;               // Total = left + right + root
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

        int totalSum = sum(root);
        System.out.println(totalSum); // 21
    }
}

/*
  Time Complexity: O(n)
  Space Complexity: O(h)

  https://www.geeksforgeeks.org/problems/sum-of-binary-tree/1
 */
