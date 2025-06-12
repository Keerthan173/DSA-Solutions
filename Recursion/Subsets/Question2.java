// Print All Subsequences of a String Including ASCII Values (Using Recursion)

public class Question2 {
    public static void main(String[] args) {
        myFunc("","ab");
    }
    static void myFunc(String processed,String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        myFunc(processed + ch , unprocessed.substring(1));
        myFunc(processed + (ch+0) , unprocessed.substring(1));
        myFunc(processed, unprocessed.substring(1));
    }
}