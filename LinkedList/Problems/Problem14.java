// Leetcode 2130: Maximum Twin Sum of a Linked List
// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/

package Problems;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { 
        this.val = val; 
    }
}

public class Problem14 {

    public static int pairSum(ListNode head) {
        // Step 1: Find middle of the list
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode secondHalf = reverse(slow.next);
        slow.next = secondHalf;

        // Step 3: Calculate max twin sum
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        int maxSum = Integer.MIN_VALUE;
        while(p2 != null){
            int sum = p1.val + p2.val;
            maxSum = Math.max(maxSum, sum);
            p1 = p1.next;
            p2 = p2.next;
        }

        return maxSum;
    }

    // Helper method to reverse a linked list
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        while(current != null){
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    // Helper method to create a linked list from array
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        for (int val : arr) {
            temp.next = new ListNode(val);
            temp = temp.next;
        }
        return dummy.next;
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
        int[] arr = {1, 2, 3, 4}; // Expected twin sum = max(1+4, 2+3) = 5
        ListNode head = createList(arr);
        System.out.print("Original List: ");
        printList(head);

        int result = pairSum(head);
        System.out.println("Maximum Twin Sum: " + result);
    }
}

// Output:
// Original List: 1 -> 2 -> 3 -> 4 -> null
// Maximum Twin Sum: 5