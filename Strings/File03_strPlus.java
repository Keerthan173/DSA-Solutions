// string + String/number/char combinations

public class File03_strPlus {
    public static void main(String[] args) {
        String str = "abc";

        System.out.println(str + "def"); // Output: abcdef
        System.out.println(str + str); // Output: abcabc

        System.out.println(str + 7); // Output: abc7
        System.out.println(str + 7 + 8); // Output: abc78 (evaluated left to right)
        System.out.println(str + (7 + 8)); // Output: abc15 (parentheses evaluated first)
        System.out.println(7 + 8 + str); // Output: 15abc

        System.out.println(str + 7 + 8 + str); // Output: abc78abc
        System.out.println(str + (7 + 8) + str); // Output: abc15abc
        System.out.println(7 + 8 + str + str); // Output: 15abcabc

        System.out.println(str + 'd'); // Output: abcd
        System.out.println((int)'d' + str); // Output: 100abc
        System.out.println('d' + str); // Output: dabc
        System.out.println((int)'d' + 1 + str); // Output: 101abc
        System.out.println('d' + 1 + str); // Output: 101abc

        // Advanced combinations
        System.out.println(str + 'a' + 'b');           // Output: abcab (char becomes string here)
        System.out.println('a' + 'b' + str);           // Output: 195abc (97 + 98 = 195, then 195 + str)
        System.out.println((char)(str.charAt(0) + 1)); // Output: b ('a' + 1)
        System.out.println(str + (char)('a' + 1));     // Output: abcb (char arithmetic: 'a'+1 = 'b')
        System.out.println(str + (char)(str.charAt(0) + 1)); // Output: abcb (char arithmetic: 'a'+1 = 'b')

    }
}
