public class Nto1 {
    public static void main(String[] args) {
        myFun(5);           // 5 4 3 2 1
        // myFunRev(5);       // 1 2 3 4 5
    }
    static void myFun(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" ");
        myFun(n-1);
    }

    // static void myFunRev(int n){
    //     if(n==0){
    //         return;
    //     }
    //     myFunRev(n-1);
    //     System.out.print(n+" ");
    // }
}