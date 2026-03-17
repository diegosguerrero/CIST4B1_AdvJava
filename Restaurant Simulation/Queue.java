public class Queue<T> {

    private Object [] data;
    private int size; //Equivalent to maxSize
    private int head;
    private int tail;

    public Queue(int size){
        this.size = 0;
        data = new Object[size];
        head = 0;
        tail = 0;
    }

    public void enQueue(T item) {
        if (size == data.length) {
            //Grow
     
            //Want to insert the data unwrapped
        } else {
            this.data[this.tail] = item;
            this.tail = (this.tail + 1) % data.length; //% is the remainder of a division
            size++;
        }
    }
    
    public T deQueue(){
        if (size == 0) {
            System.err.println("Error: Atempting to remove from empty queue");
            return null;
        } else {
            T returnValue = (T) this.data[this.head];
            this.data[this.head] = null;
            this.head = (this.head + 1) % data.length;
            this.size--;
            return returnValue;
        }
    }

     public T Peek() { //Time Complexity O(1)
        if (!this.isEmtpy()) {
            return (T) this.data[this.head];
        } else {
            System.err.println("Error: Attempting to remove from empty stack.");
            return null;
        }
    }

    public boolean isEmtpy(){ //Time Complexity O(1)
        return this.size == 0;

    }

    public boolean isFull() { //Time Complexity O(1)
        return this.size == this.data.length;
    }

    public int getLength() {
        return this.size;
    }

    public int size() {
    return this.size;
}
}
