class Basics {
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

        display(x);     // 1 -> 2 -> 3 -> END
        displayRecursive(x);        // 1 -> 2 -> 3 -> END
        displayReverse(x);      // END <-3 <- 2 <- 1 <-
        
        System.out.println("\n"+length(x));     // 3
    }


    static void display(Node temp){
        while(temp!=null){
            System.out.print(temp.data + " -> ");
            temp=temp.next;
        }
        System.out.println("END");
    }

    static void displayRecursive(Node temp){
        if(temp==null){
            System.out.println("END");
            return;
        }
        System.out.print(temp.data + " -> ");
        displayRecursive(temp.next);
    }

    static void displayReverse(Node temp){
        if(temp==null){
            System.out.print("END <-");
            return;
        }
        displayReverse(temp.next);
        System.out.print(temp.data + " <- ");
    }

    static int length(Node temp){
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    
}

