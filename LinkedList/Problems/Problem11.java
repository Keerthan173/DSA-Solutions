// Leetcode 328: Odd Even Linked List
// https://leetcode.com/problems/odd-even-linked-list/
// Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices.
// The first node is considered odd, and the second node is even, and so on.

package Problems;

public class Problem11 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;             // start from 1st node
        ListNode even = head.next;       // start from 2nd node
        ListNode evenHead = even;        // remember head of even list

        while (even != null && even.next != null) {
            odd.next = even.next;        // link odd to next odd node
            odd = odd.next;

            even.next = odd.next;        // link even to next even node
            even = even.next;
        }

        odd.next = evenHead;             // append even list at end of odd list
        return head;
    }

    // Helper method to print the list
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

        oddEvenList(head);

        System.out.print("Rearranged List (odd-even): ");
        printList(head);
    }
}
// Output:
// Original List: 1 -> 2 -> 3 -> 4 -> 5 -> null
// Rearranged List (odd-even): 1 -> 3 -> 5 -> 2 -> 4 -> null