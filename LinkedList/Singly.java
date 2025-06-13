import java.util.NoSuchElementException;

public class Singly {
    public static void main(String[] args) {

        LinkedList list=new LinkedList();

        list.insertFirst(10);
        list.insertLast(20);
        list.display();     //10->20->END
        System.out.println(list.length());      // 2
        list.insertFirst(3);
        list.insertLast(7);
        list.display();     //3->10->20->7->END
        list.insert(55, 1);
        list.insert(27, 2);
        list.display();     //3->55->27->10->20->7->END

        System.out.println("Deleted First:"+list.deleteFirst());        //Deleted First:3
        System.out.println("Deleted Last:"+list.deleteLast());          //Deleted Last:7
        list.display();     //55->27->20->END
        System.out.println("Deleted at index 2:"+list.delete(2));       //Deleted at index 2:10
        list.display();     //55->27->20->END
        System.out.println("Deleted:"+list.deleteByValue(27));      //Deleted:27
        list.display();     //55->20->END
    }
}

class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value){
            this.value=value;
        }
        public Node(int value,Node next){
            this.value=value;
            this.next=next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int val){
        if(tail==null){
            insertFirst(val);
            return;
        }
        Node node=new Node(val);
        tail.next=node;
        tail=node;
        size++;

    }

    public void insert(int val,int index){
        // Check for invalid index
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if(index==0){
            insertFirst(val);
            return;
        }
        if(index==size){
            insertLast(val);
            return;
        }
        Node temp=head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        Node node=new Node(val,temp.next);
        //OR
        // Node node=new Node(val);
        // node.next=temp.next;
        temp.next=node;

        size++;
    }

    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.println("END");
    }

    public int length(){
        return size;
    }

    public int deleteFirst(){
        if (head == null) {
            throw new NoSuchElementException("Cannot delete from an empty list");
        }
        int deletedValue=head.value;
        if(head==tail){
            head=tail=null;
        }else{
            head=head.next;
        }
        size--;
        return deletedValue;
    }

    public Node get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node node=head;
        for(int i=0;i<index;i++){
            node=node.next;
        }
        return node;
    }
    
    public int deleteLast(){
        if (head == null) {
            throw new NoSuchElementException("Cannot delete from an empty list");
        }
        int deletedValue=tail.value;
        //Case 1: Only one node in the list
        if(head==tail){
            head=null;
            tail=null;
        }
        // Case 2: Multiple nodes, traverse to the second-last node
        else{
            Node secondLast=get(size-2);
            tail=secondLast;
            tail.next=null;
        }
        size--;
        return deletedValue;
    }

    public int delete(int index){
        if(index==0){
            return deleteFirst();
        }
        if(index==size-1){
            return deleteLast();
        }
        Node prev=get(index-1);
        int deletedValue=prev.next.value;
        prev.next=prev.next.next;
        size--;
        return deletedValue;
    }

    public Node findNode(int value){
        Node node=head;
        while(node!=null){
            if(node.value==value){
                return node;
            }
            node=node.next;
        }
        return null;
    }
    
    public int deleteByValue(int value){
        Node node=findNode(value);
        if(node==null){
            throw new NoSuchElementException("Element not found.");
        }
        if(node==head){
            return deleteFirst();
        }
        if(node==tail){
            return deleteLast();
        }
        Node prev=head;
        while(prev.next!=node){
            prev=prev.next;
        }
        prev.next=node.next;
        int deletedValue=node.value;
        size--;
        return deletedValue;
    }

}