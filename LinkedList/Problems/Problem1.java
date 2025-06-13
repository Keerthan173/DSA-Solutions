// LeetCode 237: Delete Node in a Linked List
// https://leetcode.com/problems/delete-node-in-a-linked-list/

// Given only access to a node (not the head) in a singly linked list,
// delete the given node from the list.
// Note: The given node is not the last node.

package Problems;

public class Problem1 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    // Deletes the given node from the list (not the last node).
    public static void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating the list: 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        System.out.print("Before deletion: ");
        printList(head);
        // Before deletion: 4 -> 5 -> 1 -> 9 -> null

        // Suppose we are given node 5 (head.next)
        deleteNode(head.next);

        System.out.print("After deleting node 5: ");
        printList(head); 
        // After deleting node 5: 4 -> 1 -> 9 -> null
    }
}