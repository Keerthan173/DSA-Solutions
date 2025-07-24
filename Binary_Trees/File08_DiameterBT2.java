public class File08_DiameterBT2 {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    // Helper class to store height and diameter
    static class Info {
        int height;
        int diameter;

        Info(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    // Diameter of Binary Tree
    public static Info diameterBT(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameterBT(root.left);
        Info rightInfo = diameterBT(root.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        int diamThroughRoot = leftInfo.height + rightInfo.height + 1;
        int maxDiam = Math.max(diamThroughRoot, Math.max(leftInfo.diameter, rightInfo.diameter));

        return new Info(height, maxDiam);
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

        System.out.println("Diameter of BT: " + diameterBT(root).diameter); // 5 (Number of nodes)
        System.out.println("Diameter of BT: " + (diameterBT(root).diameter - 1)); // 4 (length of the path)

        System.out.println("Height of BT:" + diameterBT(root).height); // 3
    }
}

/*
Time Complexity: O(n)
 */
