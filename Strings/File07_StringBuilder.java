/*
Why StringBuilder?
- In Java, `String` is immutable — meaning once created, its value cannot be changed.
- Every time you perform a string modification (like `+` or `concat()`), a **new String object** is created.
- This is inefficient in cases of repeated modifications (like in loops).
- ➤ To solve this, Java provides `StringBuilder` (and `StringBuffer`) for **mutable strings**.

StringBuilder is:
- Fast (non-synchronized → not thread-safe, but efficient for single-threaded tasks)
- Memory efficient (modifies existing object instead of creating new one)
*/

public class File07_StringBuilder {
    public static void main(String[] args) {
        // Creating a StringBuilder object
        StringBuilder sb = new StringBuilder("Hello");

        // Append text
        sb.append(" World");
        System.out.println(sb); // Output: Hello World

        // Insert text at a specific index
        sb.insert(5, "_Java");
        System.out.println(sb); // Output: Hello_Java World

        // Replace a part of the string
        sb.replace(6, 10, "Python"); // from index 6 to 9 (exclusive of 10)
        System.out.println(sb); // Output: Hello_Python World

        // Delete part of the string
        sb.delete(5, 12); // Removes from index 5 to 11
        System.out.println(sb); // Output: Hello World

        // Reverse the string
        sb.reverse();
        System.out.println(sb); // Output: dlroW olleH

        // Convert back to String
        String str = sb.toString();
        System.out.println("Converted to String: " + str); // Output: dlroW olleH
    }
}
