// Print All Subsequences (Subsets) of a String Using Recursion.
public class Question1 {
    public static void main(String[] args) {
        myFunc("", "abc");
    }
    static void myFunc(String processed,String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch=unprocessed.charAt(0);
        myFunc(processed+ch, unprocessed.substring(1));
        myFunc(processed, unprocessed.substring(1));
    }
}

// Output:
// abc
// ab
// ac
// a
// bc
// b
// c
// (empty string)