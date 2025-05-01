public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(myFunc(12342));
    }
    static int myFunc(int n){
        if(n==0) return 0;
        return (n%10) + myFunc(n/10);
    }
}
