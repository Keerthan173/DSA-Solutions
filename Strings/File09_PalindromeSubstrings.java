// Count and print all palindrome substrings in a given string

public class File09_PalindromeSubstrings {

    static int count = 0;

    public static void main(String[] args) {
        String str = "abcba";

        // Iterate over all possible substrings
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                // Get each substring from index i to j (exclusive)
                String sub = str.substring(i, j);
                isPalindrome(sub);
            }
        }

        System.out.println("\nTotal Palindromic Substrings: " + count);
    }

    public static void isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        boolean flag = true;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                flag = false;
                break;
            }
            i++;
            j--;
        }

        // If the string is a palindrome, increment count and print it
        if (flag) {
            count++;
            System.out.print(str + " ");
        }
    }
}

// Output:
// a abcba b bcb c b a 
// Total Palindromic Substrings: 7
