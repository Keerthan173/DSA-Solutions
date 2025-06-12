// Generate All Permutations of a String Using Recursion

package Permutations;

import java.util.ArrayList;

public class Problem2 {
    public static void main(String[] args) {
        ArrayList<String> list = myFunc("", "abc");
        System.out.println(list);       // [cba, bca, bac, cab, acb, abc]
    }

    static ArrayList<String> myFunc(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            ArrayList<String> result = new ArrayList<>();
            result.add(processed);
            return result;
        }
        char ch = unprocessed.charAt(0);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <= processed.length(); i++) {

            String first = processed.substring(0, i);
            String second = processed.substring(i, processed.length());

            list.addAll(myFunc(first + ch + second, unprocessed.substring(1)));
        }
        return list;
    }
}
