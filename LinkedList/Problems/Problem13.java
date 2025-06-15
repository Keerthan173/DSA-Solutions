// Leetcode 234: Palindrome Linked List
// https://leetcode.com/problems/palindrome-linked-list/

package Problems;

public class Problem13 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { 
            this.val = val; 
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Finding the middle (left middle for even)
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        } 

        // Reversing the second half
        ListNode temp = reverse(slow.next);
        slow.next = temp;       // Linking two halves

        // Comparing two halves
        ListNode p1 = head;
        ListNode p2 = temp;

        while(p2!=null){
            if(p1.val!=p2.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        ListNode after = null;
        while(current != null){
            after = current.next;
            current.next = prev;
            prev = current;
            current = after;
        }
        return prev;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create a palindrome list: 1 -> 2 -> 2 -> 1
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(2);
        a.next.next.next = new ListNode(1);

        System.out.print("Input List: ");
        printList(a);

        boolean result = isPalindrome(a);
        System.out.println("Is Palindrome? " + result);
    }
}


// Output:
// Input List: 1 -> 2 -> 2 -> 1 -> null
// Is Palindrome? true


// Restore List:
// If the problem requires the list to remain unchanged, restore the second half by reversing it again:
// slow.next = reverse(slow.next);
// Place this line after the palindrome check.


// ⏱ Time and Space Complexity
// Time: O(n) – single pass to find middle, one for reverse, and one to compare.
// Space: O(1) – in-place operations.
