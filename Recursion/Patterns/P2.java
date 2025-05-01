public class P2 {
    public static void main(String[] args) {
        int n=4;
        myFunc(n, 0);
    }
    static void myFunc(int row,int col){
        if(row==0){
            return;
        }
        if(row>col){
            myFunc(row, col+1);
            System.out.print("* ");
        }else{
            myFunc(row-1, 0);
            System.out.println();
        }
    }
}