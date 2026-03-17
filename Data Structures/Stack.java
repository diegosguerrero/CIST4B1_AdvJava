public class Stack<T> {

    private int maxSize;
    private int currentSize;
    private Object[] data;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        data = new Object[maxSize];

        this.currentSize = 0;

    }

    public void Push(T item) { //Time Complexity O(n)
        if (!this.isFull()) {
            data[currentSize] = item;
            currentSize++;

        } else {
            // We need to grow
            Object[] newData = new Object[this.maxSize * 2];
            for (int i = 0; i < this.maxSize; i++) {
                newData[i] = this.data[i];
            }
            newData[this.currentSize] = item;
            this.data = newData;
            this.maxSize *= 2;
            this.currentSize++; 
        }
    }

    public T Pop() { //Time Complexity O(1)
        if (!this.isEmtpy()) {

            currentSize--;
            T returnValue = (T) data[currentSize];

            data[currentSize] = null;
            return returnValue;
        } else {
            System.err.println("Error: Attempting to remove from empty stack.");
            return null;
        }
    }

    public T Peek() { //Time Complexity O(1)
        if (!this.isEmtpy()) {
            return (T) data[currentSize - 1];
        } else {
            System.err.println("Error: Attempting to remove from empty stack.");
            return null;
        }
    }

    public boolean isEmtpy(){ //Time Complexity O(1)
        return currentSize == 0;

    }

    public boolean isFull() { //Time Complexity O(1)
        return currentSize == maxSize;
    }
}
