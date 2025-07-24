import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class File10_TopView {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    static class Info1{
        Node node;
        int hd;
        public Info1(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
    if (root == null) {
        return;
    }

    // Queue for level-order traversal: stores node and its horizontal distance
    Queue<Info1> q = new LinkedList<>();

    // Map to store the first node at each horizontal distance
    HashMap<Integer, Node> map = new HashMap<>();

    // Track the minimum and maximum horizontal distances
    int min = 0, max = 0;

    q.add(new Info1(root, 0)); // Root node has hd = 0
    q.add(null);               // Marker for level end

    while (!q.isEmpty()) {
        Info1 currNode = q.remove();

        if (currNode == null) {
            // End of level
            if (q.isEmpty()){
                break;
            }
            q.add(null); // Add marker for next level
        } 
        else {
            // If this horizontal distance hasn't been recorded yet, add it
            if (!map.containsKey(currNode.hd)) {
                map.put(currNode.hd, currNode.node);
            }

            // Process left child with hd - 1
            if (currNode.node.left != null) {
                q.add(new Info1(currNode.node.left, currNode.hd - 1));
                min = Math.min(min, currNode.hd - 1); // update min hd
            }

            // Process right child with hd + 1
            if (currNode.node.right != null) {
                q.add(new Info1(currNode.node.right, currNode.hd + 1));
                max = Math.max(max, currNode.hd + 1); // update max hd
            }
        }
    }

    // Print top view from leftmost hd to rightmost hd
    for (int i = min; i <= max; i++) {
        System.out.print(map.get(i).data + " ");
    }
    System.out.println();
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

        topView(root); // 4 2 1 3 6 
    }
}
