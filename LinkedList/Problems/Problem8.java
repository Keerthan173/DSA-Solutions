// Leetcode 142: Linked List Cycle - 2
// https://leetcode.com/problems/linked-list-cycle-ii/
// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

package Problems;

public class Problem8 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode hasCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        boolean cycle = false;

        // Step 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                cycle = true;
                break;
            }
        }

        // Step 2: If no cycle, return null
        if (!cycle) return null;

        // Step 3: Find the starting point of the cycle
        ListNode start = head;
        while( start != slow ){
            start = start.next;
            slow = slow.next;
        }
        return start;
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

        ListNode result = hasCycle(a);
        if (result != null) {
            System.out.println("Cycle starts at node with value: " + result.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}

// Output:
// Cycle starts at node with value: 2


// After the meeting:
// Set a pointer start at the head.
// Keep moving both start and slow one step at a time.
// They will meet exactly at the cycle start.
// This is because the distance from the head to the cycle start is equal to the distance from the meeting point to the cycle start.