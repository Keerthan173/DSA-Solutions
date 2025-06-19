import java.util.Stack;

public class Stack03 {
    public static void main(String[] args) {

        Stack<Integer> mainStack = new Stack<>();
        mainStack.push(1);
        mainStack.push(2);
        mainStack.push(3);
        mainStack.push(4);
        mainStack.push(5);
        System.out.println("Original Stack: " + mainStack); 

        // Index at which to insert (0-based from bottom)
        int index = 2;        // Insert at 3rd position (below top 2 elements)
        int newValue = 333;

        // Temporary stack to hold elements above the insertion index
        Stack<Integer> tempStack = new Stack<>();

        // Pop elements until we reach the desired index
        while (mainStack.size() > index) {
            tempStack.push(mainStack.pop());
        }

        // Insert the new element at the target index
        mainStack.push(newValue);

        // Push back the elements from the temp stack
        while (!tempStack.isEmpty()) {
            mainStack.push(tempStack.pop());
        }

        System.out.println("Stack after inserting " + newValue + " at index " + index + ": " + mainStack);
    }
}

// Output:
// Original Stack: [1, 2, 3, 4, 5]
// Stack after inserting 333 at index 2: [1, 2, 333, 3, 4, 5]