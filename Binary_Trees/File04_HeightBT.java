public class File04_HeightBT {
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

    public static int heightBT(Node root){
        if(root == null){
            return 0;
        }

        int lh = heightBT(root.left);   // Recursively find height of left subtree
        int rh = heightBT(root.right);  // Recursively find height of right subtree
        int h = Math.max(lh, rh) + 1;

        return h;
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

        int height = heightBT(root);
        System.out.println("Height (Nodes): " + height);
        System.out.println("Height (Edges): " + (height-1));
    }
}

// Output:
// Height (Nodes): 3
// Height (Edges): 2


// Time Complexity - O(n) 
//     Because it visits each node once.

// Space Complexity - O(h)
//     Where h is the height of the tree (due to recursion stack)


/*
Height: https://www.geeksforgeeks.org/problems/height-of-binary-tree/1
Depth: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
