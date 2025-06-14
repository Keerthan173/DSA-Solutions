// Leetcode 83: Remove Duplicates from Sorted List
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

package Problems;

public class Problem10 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Function to remove duplicates from a sorted linked list
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                // Skip duplicate node
                temp.next = temp.next.next;
            }
            else {
                // Move to next unique node
                temp = temp.next;
            }
        }
        return head;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Sample input: 1 -> 1 -> 2 -> 3 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        System.out.print("Original list: ");
        printList(head);

        head = deleteDuplicates(head);

        System.out.print("List after removing duplicates: ");
        printList(head);
    }
}

// Output:
// Original list: 1 -> 1 -> 2 -> 3 -> 3 -> null
// List after removing duplicates: 1 -> 2 -> 3 -> null