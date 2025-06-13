// Uses two pointers to "slide" through the list, finding the target without needing to know the total size.

package Problems;

public class Problem2b {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }
    public static ListNode nthFromEnd(ListNode head , int n){
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
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
        System.out.println("The value of the node is: " + result.val);      //The value of the node is: 3
    }
}

// The first method is less efficient and less elegant, especially for long lists or real-time scenarios.

// The two-pointer method avoids all of the above issues and is the preferred solution.