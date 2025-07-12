public class File01_Basics {
    public static void main(String[] args) {
        /* Declaration and initialization of a string together in single line */
        String str = "College Wallah";
        System.out.println(str);// Output: College Wallah

        /* String functions */
            System.out.println(str.length()); // Output: 14

            // char ch = str[0];        // ERROR
            System.out.println(str.charAt(0)); // Output: C
            System.out.println(str.charAt(12)); // Output: a

            System.out.println(str.indexOf('l')); // Output: 2
            System.out.println(str.indexOf("Wallah")); // Output: 8

            System.out.println(str.compareTo("College Wallah")); // Output: 0 (both same)
            System.out.println(str.compareTo("Coj")); // Output: 2 (l is 2 places ahead of j)
            System.out.println(str.compareTo("Flag")); // Output: -3 (C is 3 places back of F)

            System.out.println(str.contains("ege Wal")); // Output: true
            System.out.println(str.contains("Keerthan")); // Output: false
            System.out.println(str.contains("allah")); // Output: true

            System.out.println(str.startsWith("College")); // Output: true
            System.out.println(str.startsWith("W")); // Output: false

            System.out.println(str.endsWith("Wallah")); // Output: true
            System.out.println(str.endsWith("Col")); // Output: false

            System.out.println(str.toLowerCase()); // Output: college wallah
            System.out.println(str.toUpperCase()); // Output: COLLEGE WALLAH

            System.out.println(str.replace('l', 'r')); // Output: Corge Warrah
            System.out.println(str.replace("Wallah", "Bhai")); // Output: College Bhai
            System.out.println(str.replace("Wallah", "Bhai").replace('C', 'c')); // Output: college Bhai

            // str.substring(start, end) returns a new string from index 'start' to 'end-1'
            // str.substring(start) returns from 'start' to end of the string
            System.out.println(str.substring(0, 7)); // Output: College
            System.out.println(str.substring(7)); // Output: Wallah
            System.out.println(str.substring(3));
    }
}
