
public class LinkedListNode <T> {
    private T data;
    private LinkedListNode<T> next;

    public LinkedListNode(T data) { // constructor
        this.data = data;
        next = null;
    }

    // Getters and Setters.

    public T getData() {
        return data;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

    public void setData(T data) {
        this.data = data;
    }

}
