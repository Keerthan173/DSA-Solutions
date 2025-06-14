// Reverse the linked list iteratively

package Problems;

public class Problem12b {

    // Definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Function to reverse the linked list iteratively
    public static ListNode reverseList(ListNode head) {
        // Method 2 - Iterative
        ListNode prev = null;
        ListNode after = null;
        ListNode current = head;

        while(current!=null){
            after = current.next;
            current.next = prev;
            prev = current;
            current = after;
        }
        return prev;
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
        // Example list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        head = reverseList(head);

        System.out.print("Reversed List: ");
        printList(head);
    }
}
