// Stack implementation using Linked List.

public class Stack08 {

    // Node class to represent each element in the stack
    private class Node {
        int data;
        Node next;

        Node(int value) {
            data = value;
            next = null;
        }
    }

    private Node top; // Top of the stack

    // Constructor: initializes an empty stack
    public Stack08() {
        top = null;
    }

    // Push operation: Add element to top
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;  // Link new node to previous top
        top = newNode;       // Update top
    }

    // Pop operation: Remove top element and return it
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop.");
            return -1;
        }
        int poppedValue = top.data;
        top = top.next;
        return poppedValue;
    }

    // Peek operation: View top element without removing
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return top.data;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Display stack elements from top to bottom
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.print("Stack (top to bottom): ");
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack08 stack = new Stack08();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();             // 30 20 10
        System.out.println("Top: " + stack.peek()); // 30

        System.out.println("Popped: " + stack.pop()); // 30
        stack.display();             // 20 10

        System.out.println("Is Empty? " + stack.isEmpty()); // false

        stack.pop();
        stack.pop();
        stack.pop();                 // Stack Underflow!
    }
}

// Output:
// Stack (top to bottom): 30 20 10 
// Top: 30
// Popped: 30
// Stack (top to bottom): 20 10 
// Is Empty? false
// Stack Underflow! Cannot pop.
