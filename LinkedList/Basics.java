public class Basics {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Node x = new Node(1);
        Node y = new Node(2);
        Node z = new Node(3);
        x.next=y;
        y.next=z;

        // x -> y -> z -> null

        System.out.println(x.data);     // 1
        System.out.println(x.next);     // Basics$Node@36baf30c
        System.out.println(y.data);     // 2
        System.out.println(x.next.data);        // 2
        System.out.println(y.next.data);        // 3
        System.out.println(x.next.next.data);   // 3
    }
}

