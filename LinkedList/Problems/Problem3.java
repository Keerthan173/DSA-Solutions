// Leetcode 19 : https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
// Remove Nth Node From End of List.

package Problems;

public class Problem3 {
    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    public static Node removeNthFromEnd(Node head, int n) {
        Node slow = head;
        Node fast = head;
        for(int i=1;i<=n;i++){
            fast = fast.next;
        }
        if(fast == null){       // If n is equal to the size of the list, we need to remove the head.
            head = head.next;
            return head;
        }
        while( fast.next != null ){     // Move fast to the end of the list - slow will point to the node before the one we want to remove.
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        a.next = b;
        b.next = c;
        c.next = d;

        printList(a);       // 1 -> 2 -> 3 -> 4 -> null

        a = removeNthFromEnd(a , 4);        // n = size of list (remove head)
        printList(a);     // 2 -> 3 -> 4 -> null

        a = removeNthFromEnd(a , 2);   
        printList(a);     // 2 -> 4 -> null

    }
}
