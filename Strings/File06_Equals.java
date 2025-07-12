// Demonstration of `==` vs `equals()` in Java Strings

public class File06_Equals {
    public static void main(String[] args) {
        // Both s1 and s2 point to the same interned string "hello" from the String pool.
        String s1 = "hello";
        String s2 = "hello";

        // s3 is a new object explicitly created using 'new', so it exists in the heap,
        // and not in the interned string pool.
        String s3 = new String("hello"); 

        // == compares the references (i.e., memory addresses)
        System.out.println(s1 == s2); // true — both refer to same string in pool
        System.out.println(s1 == s3); // false — s3 refers to a different object in heap

        // .equals() compares the actual content of the strings
        System.out.println(s1.equals(s2)); // true — both are "hello"
        System.out.println(s1.equals(s3)); // true — content is same
    }
}