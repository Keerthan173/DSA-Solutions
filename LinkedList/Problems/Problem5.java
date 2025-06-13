// Finding the first middle node in a singly linked list.

package Problems;

public class Problem5 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode firstMiddle(ListNode head){
        if (head == null) {
            return null; // If the list is empty, return null
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        // Move fast pointer two steps and slow pointer one step
        while (fast.next != null && fast.next.next != null) {   // Note that fast.next is first placed than fast.next.next
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

        // Find the first middle element
        ListNode middle = firstMiddle(head);
        if (middle != null) {
            System.out.println("First middle element: " + middle.val);  //First middle element: 2
        } else {
            System.out.println("List is empty.");
        }
    }
}
