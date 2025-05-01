public class P1 {
    public static void main(String[] args) {
        int n=4;
        myFunc(n, 0);
    }
    static void myFunc(int row,int col){
        if(row==0){
            return;
        }
        if(row>col){
            System.out.print("* ");
            myFunc(row, col+1);
        }else{
            System.out.println();
            myFunc(row-1, 0);
        }
    }
}
