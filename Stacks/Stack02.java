import java.util.Scanner;
import java.util.Stack;

public class Stack02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Create the original stack
        Stack<Integer> originalStack = new Stack<>();

        System.out.println("Enter the number of elements to insert: ");
        int n = in.nextInt();

        System.out.print("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int value = in.nextInt();
            originalStack.push(value);
        }
        System.out.println("Original Stack: " + originalStack);

        // Step 1: Reverse the original stack
        Stack<Integer> tempStack = new Stack<>();
        while (!originalStack.isEmpty()) {
            tempStack.push(originalStack.pop());
        }
        System.out.println("Reversed Stack (temp): " + tempStack);

        // Step 2: Move elements back to a new stack to restore original order
        Stack<Integer> finalStack = new Stack<>();
        while (tempStack.size() > 0) {
            finalStack.push(tempStack.pop());
        }

        System.out.println("Final Stack (same order as original): " + finalStack);

        in.close();
    }
}

// Output example:
// Enter the number of elements to insert: 
// 5
// Enter the elements:1 2 3 4 5
// Original Stack: [1, 2, 3, 4, 5]
// Reversed Stack (temp): [5, 4, 3, 2, 1]
// Final Stack (same order as original): [1, 2, 3, 4, 5]


// ✅ Time Complexity
// Let n be the number of elements entered.
// | Operation                          | Time Complexity |
// | ---------------------------------- | --------------- |
// | Reading input and pushing to stack | O(n)            |
// | Moving elements to `tempStack`     | O(n)            |
// | Moving elements to `finalStack`    | O(n)            |
// | **Total**                          | **O(n)**        |


// ✅ Space Complexity
// | Stack           | Max Elements | Space Used |
// | --------------- | ------------ | ---------- |
// | `originalStack` | n            | O(n)       |
// | `tempStack`     | n            | O(n)       |
// | `finalStack`    | n            | O(n)       |
// | **Total Space** | 3n           | **O(n)**   |