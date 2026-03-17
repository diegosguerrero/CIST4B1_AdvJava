public class Node<T> {

    //Data
    public T data;

    //Link
    public Node<T> next;

    public Node<T> prev;

    Node(T data){
        this.data = data;
        this.next = null; //Serving as end marker, absensce of any data
        this.prev = null; //For Doubly Linked List
    }
    
}
