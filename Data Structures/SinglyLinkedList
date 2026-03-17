public class SinglyLinkedList<T> {

    public Node<T> head;
    public int length;

    public SinglyLinkedList() {
        this.head = null;
        length = 0;
    }

    // -------------------- INSERTS ------------------------
    // Time complexity: O(n), it is always going to be O(n)
    public void append(T data) {

        if (head == null) {
            this.head = new Node<T>(data);
            this.length += 1;

        } else {

            Node<T> current = head;
            while (current.next != null) { // You've reached the end when your node next node says null
                current = current.next;

            }
            current.next = new Node<T>(data);
            this.length += 1;
        }
    }
    public void prepend(T data) {

        Node<T> newNode = new Node<T>(data);
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    }
    public void inserAt(T data, int index) {

        if (index < 0) {
            index = this.length + index;
        }

        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException();
            // or System.err.println("Error: Index Out Of Bounds");
            // return;
        }
        if(index == 0){
            prepend(data);
            return;
        }

        Node<T> anyNewNode = new Node<>(data);
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
           current = current.next; 
        }
        anyNewNode.next = current.next;
        current.next = anyNewNode;
        this.length++;
    }
    // -------------------- REMOVE -------------------------
    public T removeValue(T data){
        if (this.head == null){
            return null;
        }
        //Remove head
        if (this.head.data == data) {
            T returnData = this.head.data;
            this.head = this.head.next;
            this.length--;
            return returnData;
        }

        //Remove anywhere else
        Node<T> current = this.head;
        while (current.next != null) {
            if (current.next.data == data) {
                T returnData = (T) current.next.data;
                current.next = current.next.next;
                return returnData;
            }
            current = current.next;
        }
        return null;
    }
    // -------------------- SEARCH -------------------------
    public boolean search(T target) {
        if (this.head == null) {
            return false;
        }
        Node<T> current = this.head;
        while (current != null){
            if (current.data == target) {
                return true;
            }
            current = current.next;
        }
        return false;
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
    // -------------------- PRINTS -------------------------
    public void print() {
        Node<T> current = head;
        while (current.next != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println(current.data);

    }

}


    // public class Stack<T> extends SinglyLinkedList<T> {
    
    // public void Push(T item) {
    //     this.Push(item);
    // }

    // public T Pop() {
    //     return this.Pop();
    // }
