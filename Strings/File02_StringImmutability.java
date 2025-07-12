/*
String Immutability in Java

In Java, Strings are **immutable**, meaning once created, they cannot be changed.
Methods like `concat()` return a **new String** object instead of modifying the original one.
*/

public class File02_StringImmutability {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "_World";

        // Attempting to concatenate without storing result
        s1.concat(s2);
        System.out.println(s1); // Output: Hello (s1 remains unchanged)
        System.out.println(s2); // Output: _World (s2 also unchanged)

        // Actually printing the result of concat
        System.out.println(s1.concat(s2)); // Output: Hello_World
        // But original s1 is still unchanged
        System.out.println(s1); // Output: Hello
        System.out.println(s2); // Output: _World

        // To retain the result, we must assign it to a new variable
        String s3 = s1.concat(s2);
        System.out.println(s3); // Output: Hello_World

        //String immutability
        // s1.charAt(0)='H'; // This will cause a compile-time error because strings are immutable

        // Alternatively, we can update s1 with the concatenated result
        s1 = s1.concat(s2); // Now s1 is updated
        System.out.println(s1); // Output: Hello_World

        /* 
        s1 was pointing to the string literal "Hello" in the String pool (a special memory area for string constants).

        When you called `s1.concat(s2)`, it created a new string "Hello_World" but did not change the original `s1`.

        Because Strings are immutable in Java. 
        So s1.concat(s2) does not change the original s1; it just returns a new string. 
        You need to store that result if you want to use it. 
        
        The old "Hello" string remains in memory until Java's Garbage Collector cleans it up — if no references to it remain.
        */
    }
}
