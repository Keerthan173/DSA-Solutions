public class Doubly {
    public static void main(String[] args) {
        DLL list=new DLL();
        list.insertFirst(1);
        list.insertLast(2);
        list.display();     //1->2->END
        list.displayReverse();      //END<-2<-1
        list.insertAfterValue(2, 7);      
        list.display();     //1->2->7->END
        list.insert(333, 1);
        list.display();     // 1->333->2->7->END

    }
    
}
class DLL {
    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value){
            this.value=value;
        }
        // public Node(int value,Node next,Node prev){
        //     this.value=value;
        //     this.next=next;
        //     this.prev=prev;
        // }
    }

    private Node head;
    private int size;
    
    public void insertFirst(int val){
        Node node = new Node(val);
        node.prev=null;
        node.next=head;
        if(head!=null){
            head.prev=node;
        }
        head=node;
        size++;
    }

    public void insertLast(int val){
        Node node=new Node(val);
        node.next=null;
        if(head==null){
            node.prev=null;
            head=node;
        }
        else{
            Node last=head;
            while(last.next!=null){
                last=last.next;
            }
            last.next=node;
            node.prev=last;
        }
        size++;
    }

    public Node get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }
    public void insert(int val,int index){
        if(index==0){
            insertFirst(val);
            return;
        }
        if(index==size){
            insertLast(val);
            return;
        }
        Node before=get(index-1);
        Node after=get(index);
        Node node=new Node(val);

        before.next=node;
        node.prev=before;
        after.prev=node;
        node.next=after;

        size++;
    }
    
    //Insert after the given element
    public Node find(int value){
        Node node=head;
        while(node!=null){
            if(node.value==value){
                return node;
            }
            node=node.next;
        }
        return null;
    }
    public void insertAfterValue(int after,int val){
        Node p=find(after);
        if(p==null){
            System.out.println("Does not exist.");
            return;
        }
        Node node=new Node(val);
        node.next=p.next;
        p.next=node;
        node.prev=p;
        if(node.next!=null){
            node.next.prev=node;
        }
        size++;
    }

    public void display(){
        Node node=head;
        while(node!=null){
            System.out.print(node.value+"->");
            node=node.next;
        }
        System.out.println("END");
    }

    public void displayReverse(){
        Node node=head;
        Node last=null;
        while (node!=null) {
            last=node;
            node=node.next;
        }
        System.out.print("END");
        while (last!=null) {
            System.out.print("<-"+last.value);
            last=last.prev;
        }
        System.out.println();
    }
}