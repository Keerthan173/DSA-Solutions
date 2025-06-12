// Return All Subsequences of a String Including ASCII Values

import java.util.ArrayList;

public class Question2b {
    public static void main(String[] args) {
        ArrayList<String> result = myFunc("", "ab");
        System.out.println(result);     // [ab, a98, a, 97b, 9798, 97, b, 98, ]
    }

    static ArrayList<String> myFunc(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            ArrayList<String> result = new ArrayList<>();
            result.add(processed);
            return result;
        }
        char ch = unprocessed.charAt(0);
        ArrayList<String> first = myFunc(processed + ch, unprocessed.substring(1));
        ArrayList<String> second = myFunc(processed + (ch + 0), unprocessed.substring(1));
        ArrayList<String> third = myFunc(processed, unprocessed.substring(1));

        first.addAll(second);
        first.addAll(third);
        return first;
    }
}
