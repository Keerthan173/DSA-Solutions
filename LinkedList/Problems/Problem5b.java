// Leetcode 876 : Middle of the Linked List
// https://leetcode.com/problems/middle-of-the-linked-list/
// Finding the second middle node in a singly linked list.

package Problems;

public class Problem5b {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode secondMiddle(ListNode head){
        if (head == null) {
            return null; // If the list is empty, return null
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        // Move fast pointer two steps and slow pointer one step
        while (fast != null && fast.next != null) {   // Note that fast is first placed than fast.next.next
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow; // Slow pointer will be at the middle node
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Find the second middle element
        ListNode middle = secondMiddle(head);
        if (middle != null) {
            System.out.println("Second middle element: " + middle.val);  //Second middle element: 3
        } else {
            System.out.println("List is empty.");
        }
    }
}
