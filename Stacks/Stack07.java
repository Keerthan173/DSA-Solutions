// Stack implementation using an array

public class Stack07 {
    private int[] stackArray;
    private int top;
    private int capacity;

    // Constructor to initialize stack
    public Stack07(int size) {
        capacity = size;
        stackArray = new int[capacity];
        top = -1;  // Stack is initially empty
    }

    // Push an element to the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + value);
            return;
        }
        stackArray[++top] = value;
    }

    // Pop the top element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop");
            return -1;
        }
        return stackArray[top--];
    }

    // Peek the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return stackArray[top];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Display the contents of the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }

        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        Stack07 stack = new Stack07(5); // capacity = 5

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();      // 30 20 10

        System.out.println("Top element is: " + stack.peek()); // 30

        System.out.println("Popped: " + stack.pop()); // 30
        stack.display();      // 20 10

        stack.push(40);
        stack.push(50);
        stack.push(60);       // Now full
        stack.push(70);       // Overflow

        stack.display();      // 60 50 40 20 10
    }
}

// Output:
// Stack (top to bottom): 30 20 10 
// Top element is: 30
// Popped: 30
// Stack (top to bottom): 20 10 
// Stack Overflow! Cannot push 70
// Stack (top to bottom): 60 50 40 20 10 


// | Operation       | Time Complexity | Space Complexity |
// | --------------- | --------------- | ---------------- |
// | push, pop, peek | O(1)            | O(n) (for array) |
// | display         | O(n)            | O(1)             |