// https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
// Boundary Traversal:
    // Left boundary (excluding leaves)
    // All leaf nodes
    // Right boundary (excluding leaves, in reverse order)


import java.util.*;

public class File21_BoundaryTraversal {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static List<Integer> boundaryTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        if (!isLeaf(root)) res.add(root.data);

        addLeftBoundary(root.left, res);
        addLeaves(root, res);
        addRightBoundary(root.right, res);

        return res;
    }

    private static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    // Add left boundary (excluding leaves)
    private static void addLeftBoundary(Node node, List<Integer> res) {
        while (node != null) {
            if (!isLeaf(node)) res.add(node.data);
            if (node.left != null) node = node.left;
            else node = node.right;
        }
    }

    // Add all leaf nodes (left to right)
    private static void addLeaves(Node node, List<Integer> res) {
        if (node == null) return;

        if (isLeaf(node)) {
            res.add(node.data);
            return;
        }

        addLeaves(node.left, res);
        addLeaves(node.right, res);
    }

    // Add right boundary in reverse (excluding leaves)
    private static void addRightBoundary(Node node, List<Integer> res) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if (!isLeaf(node)) stack.push(node.data);
            if (node.right != null) node = node.right;
            else node = node.left;
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        /*
                   1
                 /   \
                2     3
               / \   / \
              4   5 6   7
                     \
                      8

            Boundary: 1 2 4 5 6 8 7 3
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        List<Integer> boundary = boundaryTraversal(root);
        System.out.println("Boundary Traversal: " + boundary);
    }
}