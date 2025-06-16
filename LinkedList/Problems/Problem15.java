// Leetcode 138: Copy List with Random Pointer
// https://leetcode.com/problems/copy-list-with-random-pointer/
// This problem involves creating a deep copy of a linked list where each node has an additional random pointer that can point to any node in the list or be null.


package Problems;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
    }
}

public class Problem15 {

    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Insert copied nodes after original nodes
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        // Step 2: Assign random pointers
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate original and copied lists
        current = head;
        Node dummy = new Node(0);
        Node copyCurrent = dummy;

        while (current != null) {
            copyCurrent.next = current.next;
            current.next = current.next.next;

            current = current.next;
            copyCurrent = copyCurrent.next;
        }

        return dummy.next;
    }

    // Utility to print list with random pointers
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            int randomVal = temp.random != null ? temp.random.val : -1;
            System.out.println("Node: " + temp.val + ", Random: " + randomVal);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        // Create test list manually: 1 -> 2 -> 3, with randoms
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next = n2;
        n2.next = n3;

        n1.random = n3;
        n2.random = n1;
        n3.random = n2;

        System.out.println("Original List:");
        printList(n1);

        Node copiedHead = copyRandomList(n1);

        System.out.println("\nCopied List:");
        printList(copiedHead);
    }
}


// Output:
// Original List:
// Node: 1, Random: 3
// Node: 2, Random: 1
// Node: 3, Random: 2

// Copied List:
// Node: 1, Random: 3
// Node: 2, Random: 1
// Node: 3, Random: 2
