// Skip string "apple"
class Question2String {
    public static void main(String[] args) {
        System.out.println(skipApple("abcapplexyzappk"));       //abcxyzappk
    }
    static String skipApple(String x){
        if(x.isEmpty()){
            return "";
        }
        if(x.startsWith("apple")){
            return skipApple(x.substring(5));
        }else{
            return x.charAt(0) + skipApple(x.substring(1));
        }
    }
}
