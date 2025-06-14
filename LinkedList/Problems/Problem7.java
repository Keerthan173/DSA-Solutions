// Leetcode 141: Linked List Cycle
// https://leetcode.com/problems/linked-list-cycle/

package Problems;

public class Problem7 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to detect if there's a cycle in the linked list
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        // Creating a linked list with a cycle
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(-4);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b; // Cycle here (points back to node with value 2)

        // Check if the linked list has a cycle
        boolean result = hasCycle(a);
        System.out.println("Cycle detected: " + result); // Output: true
    }
}
