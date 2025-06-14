// Leetcode 21 :Merge Two Sorted Lists
// https://leetcode.com/problems/merge-two-sorted-lists/

// Method 2: In-Place Merging
// Reuses existing nodes and adjusts next pointers.
// Memory Usage: O(1), since no new nodes are created.

package Problems;

public class Problem9b {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        ListNode temp1 = head1;
        ListNode temp2 = head2;

        ListNode head = new ListNode(100);      // Dummy head
        ListNode temp = head;

        while(temp1!=null && temp2!=null){
            if(temp1.val < temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1!=null){
            temp.next = temp1;
        }else{
            temp.next = temp2;
        }
        return head.next;
    }

    // Print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // First list: 9 -> 7 -> 5
        ListNode a = new ListNode(9);
        a.next = new ListNode(7);
        a.next.next = new ListNode(5);

        // Second list: 8 -> 6 -> 4
        ListNode b = new ListNode(8);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);

        System.out.print("List 1: ");
        printList(a);

        System.out.print("List 2: ");
        printList(b);

        ListNode merged = merge(a, b);

        System.out.print("Merged List: ");
        printList(merged); 
    }
}
// Output:
// List 1: 9 -> 7 -> 5 -> null
// List 2: 8 -> 6 -> 4 -> null
// Merged List: 8 -> 6 -> 4 -> 9 -> 7 -> 5 -> null
