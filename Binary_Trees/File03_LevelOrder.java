import java.util.LinkedList;
import java.util.Queue;

public class File03_LevelOrder {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // BinaryTree class to build the tree from a preorder array
    static class BinaryTree {
        static int idx = -1;

        public Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void levelOrder(Node root){
        if(root == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root); // Add root node to queue
        q.add(null); // Add null marker to separate levels

        while (!q.isEmpty()) {
            Node curNode = q.remove();

            if(curNode==null){
                System.out.println(); // End of current level
                if(q.isEmpty()){
                    break;              // All levels completed
                }
                q.add(null);            // Add marker for next level
            }else{
                System.out.print(curNode.data + " ");

                if(curNode.left != null){
                    q.add(curNode.left);    // Enqueue left child
                }
                if(curNode.right != null){
                    q.add(curNode.right);   // Enqueue right child
                }
            }
        }
    }
    public static void main(String[] args) {

        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        // Build this binary tree using preorder array:
        //         1
        //       /   \
        //      2     3
        //     / \     \
        //    4   5     6


        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        // Output: Level order traversal
        levelOrder(root);
    }
}

/*
1 
2 3
4 5 6
 */


// Time Complexity = O(n)
// Where n = number of nodes in the binary tree.
//     Each node is visited exactly once.
//     Each node is added to the queue once and removed once.
