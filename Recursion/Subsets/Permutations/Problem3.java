// Generate All Permutations of a String Using Recursion

package Permutations;

public class Problem3 {
    public static void main(String[] args) {
        int count=myFunc("", "abc");
        System.out.println(count);      // 6
    }

    static int myFunc(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            return 1;
        }
        int count =0;
        char ch = unprocessed.charAt(0);
        for (int i = 0; i <= processed.length(); i++) {

            String first = processed.substring(0, i);
            String second = processed.substring(i, processed.length());

            count = count + myFunc(first + ch + second, unprocessed.substring(1));
        }
        return count;
    }
}
