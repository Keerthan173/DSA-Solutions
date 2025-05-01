import java.util.NoSuchElementException;

public class Singly {
    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.insertFirst(10);
        list.insertLast(20);
        list.display();
        list.insertFirst(3);
        list.insertLast(7);
        list.display();
        list.insert(55, 1);
        list.display();
        System.out.println("Deleted First:"+list.deleteFirst());
        System.out.println("Deleted Last:"+list.deleteLast());
        list.display();
        System.out.println(list.delete(2));
        System.out.println(list.findNode(55));
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
        System.err.println("END");
    }

    public int deleteFirst(){
        if (head == null) {
            throw new NoSuchElementException("Cannot delete from an empty list");
        }
        int deletedValue=head.value;
        head=head.next;
        size--;
        return deletedValue;
    }

    public Node get(int index){
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
}