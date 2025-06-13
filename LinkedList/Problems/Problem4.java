// Leetcode 160 : Intersection of Two Linked Lists
// Given the heads of two singly linked lists, return the node at which the two lists intersect.
// If the two linked lists have no intersection at all, return null.

package Problems;

public class Problem4 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        int len1=0;
        while(temp1 != null){
            len1++;
            temp1 = temp1.next;
        }
        int len2=0;
        while(temp2 != null){
            len2++;
            temp2 = temp2.next;
        }

        temp1 = headA;
        temp2 = headB;

        if(len1 > len2){
            int steps = len1 - len2;
            for(int i=1;i<=steps;i++){
                temp1 = temp1.next;
            }
        }else{
            int steps = len2 - len1;
            for(int i=1;i<=steps;i++){
                temp2 = temp2.next;
            }
        }
        // Traverse together until intersection or end
        while (temp1 != null && temp2 != null) {
            if (temp1 == temp2){
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return null; // No intersection
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode b1 = new ListNode(4);
        ListNode b2 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        b1.next = b2;
        b2.next = a2; // Intersection at node with value 2

        ListNode intersection = getIntersectionNode(a1, b1);
        if (intersection != null) {
            System.out.println("The intersection node value is: " + intersection.val); // The intersection node value is: 2
        } else {
            System.out.println("No intersection found.");
        }
    }
}