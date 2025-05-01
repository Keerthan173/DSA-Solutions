// Skip character 'a'
public class Question1 {
    public static void main(String[] args) {
        skipA("", "abcabaakak");        //bcbkk

        System.out.println(skipA2("aabbcadeafa"));      //bbcdef
    }

    // Method 1
    static void skipA(String newString, String oldString){
        if (oldString.isEmpty()) {
            System.out.println(newString);
            return;
        }
        char ch=oldString.charAt(0);
        if(oldString.charAt(0)=='a'){
            skipA(newString, oldString.substring(1));
        }else{
            skipA(newString+ch, oldString.substring(1));
        }
    }


    //Method 2
    static String skipA2(String x){
        if(x.isEmpty()){
            return "";
        }
        char ch=x.charAt(0);
        if(ch=='a'){
            return skipA2(x.substring(1));
        }
        return ch + skipA2(x.substring(1));
    }
}