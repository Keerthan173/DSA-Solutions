// Generate All Permutations of a String Using Recursion

package Permutations;

public class Problem1 {
    public static void main(String[] args) {
        myFunc("", "abc");
    }

    static void myFunc(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        for (int i = 0; i <= processed.length(); i++) {

            String first = processed.substring(0, i);
            String second = processed.substring(i, processed.length());

            myFunc(first + ch + second, unprocessed.substring(1));
        }
    }
}

// Output:
// cba
// bca
// bac
// cab
// acb
// abc