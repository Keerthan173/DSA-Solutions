public class Reverse {
    //Method 1
    static int rev = 0;
    static void revFunc1(int n) {
        if (n == 0) {
            return;
        }
        int rem = n % 10;
        rev = rev * 10 + rem;
        revFunc1(n/10);
    }

    public static void main(String[] args) {
        revFunc1(1234);
        System.out.println(rev);

        // System.out.println(revFunc2(1234));
    }



    //Method 2
    static int revFunc2(int n) {
        int digits = (int)(Math.log10(n)) + 1;
        return helper(n, digits);
    }

    private static int helper(int n, int digits) {
        if (n%10 == n) {
            return n;
        }
        int rem = n % 10;
        return rem * (int)(Math.pow(10, digits-1)) + helper(n/10, digits-1);
    }
}