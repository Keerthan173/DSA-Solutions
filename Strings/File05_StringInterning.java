/* 
What is String Interning?
    String interning stores only one copy of each distinct string value.
    String literals are automatically interned by the JVM.
Why is it useful?
    Saves memory by reusing string objects.
    Faster comparisons using == because interned strings share references.
*/
public class File05_StringInterning {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");    //creates a new object in heap, not in the string pool.
        String s4 = s3.intern();
        //s3.intern():
            // Checks if "hello" already exists in the String pool.
            // If yes, returns a reference to the pooled string.
            // If not, adds it to the pool and returns that reference.
        // s4 now points to the pooled string, same as any "hello" literal.

        System.out.println(s1 == s2); // true (both are string literals, interned automatically)
        System.out.println(s1 == s3); // false (new object)
        System.out.println(s1 == s4); // true (s4 is interned to match s1's reference)
        System.out.println(s3 == s4); // false (s3 is a new object, s4 is interned)
    }
}
