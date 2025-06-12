// Generate All Subsequences of a String and Store in a List (Using Recursion).

import java.util.ArrayList;

public class Question1b {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        myFunc("", "abc", list);
        System.out.println(list);       // [abc, ab, ac, a, bc, b, c, ]
    }

    static void myFunc(String processed, String unprocessed, ArrayList<String> list) {
        if (unprocessed.isEmpty()) {
            list.add(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        myFunc(processed + ch, unprocessed.substring(1), list);
        myFunc(processed, unprocessed.substring(1), list);
    }
}