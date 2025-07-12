// File08_ToggleLetters.java
// 🎯 Toggle the case of each letter in a string using 2 approaches

public class File08_ToggleLetters {
    public static void main(String[] args) {
        String input = "Hello World";
        String toggled = toggleCase(input);
        System.out.println(toggled);  // Output: hELLO wORLD
    }

    // ✅ Approach 1: Using built-in Character methods (Simple and Safe)
    /*
    public static String toggleCase(String str) {
        StringBuilder toggled = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                toggled.append(Character.toLowerCase(c));
            } else {
                toggled.append(Character.toUpperCase(c));
            }
        }
        return toggled.toString();
    }
    */

    // ✅ Approach 2: Manual ASCII logic for toggling
    public static String toggleCase(String str){
        StringBuilder toggled = new StringBuilder(str);
        for(int i = 0; i < toggled.length(); i++) {
            char ch = toggled.charAt(i);

            // Skip spaces and non-alphabet characters
            if (!Character.isLetter(ch)) continue;

            // If uppercase, convert to lowercase
            if (ch >= 'A' && ch <= 'Z') {
                toggled.setCharAt(i, (char)(ch - 'A' + 'a'));
            }
            // If lowercase, convert to uppercase
            else if (ch >= 'a' && ch <= 'z') {
                toggled.setCharAt(i, (char)(ch - 'a' + 'A'));
            }
        }
        return toggled.toString();
    }
}
