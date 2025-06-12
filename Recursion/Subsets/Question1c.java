// Return All Subsequences (Subsets) of a String Using Recursion

import java.util.ArrayList;

public class Question1c {
    public static void main(String[] args) {
        ArrayList<String> result= myFunc("", "abc");
        System.out.println(result);     // [abc, ab, ac, a, bc, b, c, ]
    }
    static ArrayList<String> myFunc(String processed , String unprocessed){
        if(unprocessed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        ArrayList<String> withChar = myFunc(processed + ch, unprocessed.substring(1));
        ArrayList<String> withoutChar = myFunc(processed, unprocessed.substring(1));
        withChar.addAll(withoutChar);
        return withChar;
    }
}
