/*
Bottom View of Binary Tree:
Uses level-order traversal and horizontal distance (hd).
For each hd, we keep updating the node in map (last node seen at that hd).
Last node at a horizontal distance.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class File11_BottomView {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class Info2 {
        Node node;
        int hd; // horizontal distance

        public Info2(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void bottomView(Node root) {
        if (root == null) {
            return;
        }

        Queue<Info2> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>(); // stores the bottom-most node at each hd
        int min = 0, max = 0;

        q.add(new Info2(root, 0)); // root has hd = 0

        while (!q.isEmpty()) {
            Info2 curr = q.remove();

            // Always update the node at current hd — this ensures bottom-most is stored
            map.put(curr.hd, curr.node);

            // Update min/max horizontal distance
            min = Math.min(min, curr.hd);
            max = Math.max(max, curr.hd);

            if (curr.node.left != null) {
                q.add(new Info2(curr.node.left, curr.hd - 1));
            }

            if (curr.node.right != null) {
                q.add(new Info2(curr.node.right, curr.hd + 1));
            }
        }

        // Print bottom view from leftmost hd to rightmost hd
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        bottomView(root); // 4 2 6 3 7 
    }
}
