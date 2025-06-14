// Reverse a singly linked list recursively
// Leetcode 206: https://leetcode.com/problems/reverse-linked-list/

package Problems;

public class Problem12 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Recursive function to reverse the list
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create a sample list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        // Reverse the list
        head = reverseList(head);

        System.out.print("Reversed List: ");
        printList(head);
    }
}

// Output:
// Original List: 1 -> 2 -> 3 -> 4 -> 5 -> null
// Reversed List: 5 -> 4 -> 3 -> 2 -> 1 -> null


// | Feature              | Recursive                     | Iterative                  |
// | -------------------- | ----------------------------- | -------------------------- |
// | **Time Complexity**  | O(n)                          | O(n)                       |
// | **Space Complexity** | O(n) (call stack)             | O(1)                       |
// | **Stack Overflow**   | Yes (for large input)         | No                         |
// | **Code Simplicity**  | More elegant for small cases  | More robust for large data |
