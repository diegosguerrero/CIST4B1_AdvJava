public class DoublyLinkedList<T> {
 
    public Node<T> head;
    public Node<T> tail;
    public int length;
 
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
 
    // -------------------- INSERTS ------------------------
    // Time complexity: O(1), we always have a reference to both head and tail
    public void append(T data) {
 
        Node<T> newNode = new Node<>(data);
 
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
 
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length++;
    }
 
    // Time complexity: O(1)
    public void prepend(T data) {
 
        Node<T> newNode = new Node<>(data);
 
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
 
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.length++;
    }
 
    // Time complexity: O(n)
    public void insertAt(T data, int index) {
 
        if (index < 0) {
            index = this.length + index;
        }
 
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException();
        }
 
        if (index == 0) {
            prepend(data);
            return;
        }
 
        Node<T> newNode = new Node<>(data);
        Node<T> current = this.head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
 
        newNode.next = current.next;
        newNode.prev = current;
 
        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            this.tail = newNode;  // inserting at the end
        }
 
        current.next = newNode;
        this.length++;
    }
 
    // -------------------- REMOVE -------------------------
    // Time complexity: O(n)
    public T removeValue(T data) {
 
        if (this.head == null) {
            return null;
        }
 
        // Remove head
        if (this.head.data == data) {
            T returnData = this.head.data;
            this.head = this.head.next;
            if (this.head != null) {
                this.head.prev = null;
            } else {
                this.tail = null;  // list is now empty
            }
            this.length--;
            return returnData;
        }
 
        // Remove anywhere else
        Node<T> current = this.head;
        while (current.next != null) {
            if (current.next.data == data) {
                T returnData = current.next.data;
                current.next = current.next.next;
                if (current.next != null) {
                    current.next.prev = current;
                } else {
                    this.tail = current;  // removed the tail
                }
                this.length--;
                return returnData;
            }
            current = current.next;
        }
        return null;
    }
 
    // -------------------- SEARCH -------------------------
    // Time complexity: O(n)
    public boolean search(T target) {
 
        if (this.head == null) {
            return false;
        }
 
        Node<T> current = this.head;
        while (current != null) {
            if (current.data == target) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
 
    // -------------------- UTILS --------------------------
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        } else {
            return false;
        }
    }
 
    public int getLength() {
        return this.length;
    }
 
    // -------------------- PRINTS -------------------------
    // Prints forward: head -> ... -> tail
    public void print() {
        Node<T> current = this.head;
        while (current.next != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println(current.data);
    }
 
    // Prints backward: tail -> ... -> head
    public void printReverse() {
        Node<T> current = this.tail;
        while (current.prev != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println(current.data);
    }
 
}
