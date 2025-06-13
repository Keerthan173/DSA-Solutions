// Find Nth Node from End in Linked List
// Given the head of a singly linked list and an integer n,
// return the nth node from the end of the list.

package Problems;

public class Problem2 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }
    public static ListNode nthFromEnd(ListNode head , int n){
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        int x = size - n + 1;
        temp = head;
        for (int i = 1; i < x; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // The code first calculates the total size of the linked list using a single traversal.

    // Then, it finds the (size - n + 1)th node from the start and returns it as the nth node from the end.
    
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        // 1 -> 2 -> 3 -> 4

        // Find the 2nd node from the end
        ListNode result = nthFromEnd(a, 2);
        System.out.println("The value of the node is: " + result.val);      // The value of the node is: 3
    }
}
