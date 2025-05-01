public class CountOfZero {
    public static void main(String[] args) {
        System.out.println(counterFunc(0500));
    }
    static int counterFunc(int n){
        return helper(n,0);
    }
    static int helper(int n,int count){
        if(n==0){
            return count;
        }
        int rem=n%10;
        if(rem==0){
            count++;
        }
        return helper(n/10, count);
    }
}
