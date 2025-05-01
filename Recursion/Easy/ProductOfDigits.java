public class ProductOfDigits {
    public static void main(String[] args) {
        System.out.println(myFunc(1234));
    }
    static int myFunc(int n){
        if(n==0) return 1;
        return (n%10) * myFunc(n/10);
    }
}