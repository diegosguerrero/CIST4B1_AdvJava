public class StackLinkedList<T> {
    public Node<T> head;
    public int length;

    public StackLinkedList() {
        this.head = null;
        length = 0;
    }

    // -------------------- INSERTS ------------------------
    // Time complexity: O(n), it is always going to be O(n)
    public void push(T data) {

        Node<T> newNode = new Node<T>(data);
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    }
    // -------------------- REMOVE -------------------------
    public T pop(){
        if (this.head == null){
            return null;
        }
        //Remove head
        
            T returnData = this.head.data;
            this.head = this.head.next;
            this.length--;
            return returnData;
    }
    public T peek() {
        return this.head.data;
    }
    // -------------------- UTILS --------------------------
    public boolean isEmpty(){
        if (this.head == null) {
            return true;
        } else {
            return false;
        }
    }
    public int getLength(){
        return this.length;
    }
}

/*
*/
