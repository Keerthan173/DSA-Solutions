// Approach 2: Using One Stack with Encoding
// We store modified values in the stack whenever the new element is less than the current minimum.
// This way, we can track the previous minimums without a second stack.

// We maintain:
//     A single stack to store either normal or encoded values
//     A variable min to track the current minimum

// 🔐 How the Encoding Works:
// Let’s say:
//     x is the new element to be pushed
//     min is the current minimum

    // Case 1: x >= min
    // → Just push x (normal value)

    // Case 2: x < min
    // → Encode and push:
        // encodedValue = 2*x - min
        // → Update min = x
    // This encoding lets us retrieve the previous min when we pop.


// 🔓 How to Decode During Pop:
// When popping:
    // If top >= min: normal value

    // If top < min: it’s an encoded value
        // → Original min before pushing was:
            // previousMin = 2*min - encodedValue
        // Then update min = previousMin.

// 📘 Example Walkthrough:
// Push values: 5 → 3 → 7 → 2

// Step 1: Push 5
// Stack: [5]
// min = 5

// Step 2: Push 3
// 3 < 5 → encode: 2*3 - 5 = 1
// Stack: [5, 1]
// min = 3

// Step 3: Push 7
// 7 > 3 → push normally
// Stack: [5, 1, 7]
// min = 3

// Step 4: Push 2
// 2 < 3 → encode: 2*2 - 3 = 1
// Stack: [5, 1, 7, 1]
// min = 2

// 🔻 Now Start Popping:
// 1. Pop()
    // Top = 1
    // 1 < min (2) → it’s encoded
    // Decode previous min:
    //     previousMin = 2*min - top = 2*2 - 1 = 3
    // Update min = 3
    // Popped 1 (encoded for 2)

    // stack: [5, 1, 7]
    // min: 3

// 2. Pop()
    // Top = 7
    // 7 > min (3) → normal pop
    // Popped 7
    // stack: [5, 1]
    // min: 3

package MinStack;

import java.util.Stack;

public class Solution2 {
    private Stack<Long> stack;
    private long min;

    public Solution2() {
        stack = new Stack<>();
    }

    public void push(int x) {
        long val = x;

        if (stack.isEmpty()) {
            stack.push(val);
            min = val;
        }
        else if(val>=min){
            stack.push(val);
        }
        else if(val<min){
            // Value is less than current min → encode and update min
            stack.push(2*val-min);
            min = val;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        else if(stack.peek()>=min){
            stack.pop();
        }
        else if (stack.peek()<min) {    // means it was an encoded value
            long previousMin = 2*min - stack.peek();  // decode previous min
            min = previousMin;
            stack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) return -1;

        long top = stack.peek();
        if((int)top>=min){
            return (int)top;
        }
        else{       // top < min
            // This is an encoded value. Since we encode only when x < previous min,
            // the actual value is not in the stack but is stored in `min`.
            return (int)min;
        }
    }

    public int getMin() {
        if (stack.isEmpty()) return -1;
        return (int) min;
    }

    // Optional: For debugging
    public void printStack() {
        System.out.println("Stack (encoded): " + stack);
        System.out.println("Current Min: " + min);
    }

    public static void main(String[] args) {
        Solution2 ms = new Solution2();
        ms.push(5);
        ms.push(3);
        ms.push(7);
        ms.push(2);

        ms.printStack();
        System.out.println("Top: " + ms.top());       // 2
        System.out.println("Min: " + ms.getMin());    // 2

        ms.pop(); // remove 2
        System.out.println("After popping 2:");
        ms.printStack();
        System.out.println("Top: " + ms.top());       // 7
        System.out.println("Min: " + ms.getMin());    // 3

        ms.pop(); // remove 7
        ms.pop(); // remove 3
        System.out.println("After popping 7 and 3:");
        ms.printStack();
        System.out.println("Top: " + ms.top());       // 5
        System.out.println("Min: " + ms.getMin());    // 5
    }
}

// Output:
// Stack (encoded): [5, 1, 7, 1]
// Current Min: 2
// Top: 2
// Min: 2
// After popping 2:
// Stack (encoded): [5, 1, 7]
// Current Min: 3
// Top: 7
// Min: 3
// After popping 7 and 3:
// Stack (encoded): [5]
// Current Min: 5
// Top: 5
// Min: 5



// 5 → 3 → 7 → 2
// | Operation | Stack        | Min | Notes                       |
// | --------- | ------------ | --- | --------------------------- |
// | push(5)   | [5]          | 5   | Normal push                 |
// | push(3)   | [5, 1]       | 3   | Encoded (1) for 3           |
// | push(7)   | [5, 1, 7]    | 3   | Normal push                 |
// | push(2)   | [5, 1, 7, 1] | 2   | Encoded (1) for 2           |
// | pop()     | [5, 1, 7]    | 3   | Decoded from 1 → 3          |
// | pop()     | [5, 1]       | 3   | Normal pop                  |
// | pop()     | [5]          | 5   | Decoded from 1 → 5          |
// | pop()     | []           | —   | Normal pop (stack is empty) |
