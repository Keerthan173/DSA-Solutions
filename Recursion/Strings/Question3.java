// Return string with all occurrences of "app" removed, except when the word starts with "apple".
public class Question3 {
    public static void main(String[] args) {
        System.out.println(skipAppNotApple("xyzapp123applek"));         //xyz123applek
    }
    static String skipAppNotApple(String x){
        if(x.isEmpty()){
            return "";
        }
        if(x.startsWith("app") && !x.startsWith("apple")){
            return skipAppNotApple(x.substring(3));
        }else{
            return x.charAt(0) + skipAppNotApple(x.substring(1));
        }
    }
}
