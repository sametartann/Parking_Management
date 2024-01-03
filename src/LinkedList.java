// generic type. class can work with any type of data
public class LinkedList<T> {
    private LinkedListNode<T> head;
    private int size;

    public LinkedList() { // constructor
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(T data) { // add a new node containing the specified data to the end of the linked list
        LinkedListNode<T> newNode = new LinkedListNode<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            LinkedListNode<T> currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
        size++;
    }

    public void remove(T data) { // remove the first occurrence of a node with the specified data from the linked list
        if (isEmpty()) {
            return;
        }

        if (head.getData().equals(data)) {
            head = head.getNext();
            size--;
            return;
        }

        LinkedListNode<T> currentNode = head;
        LinkedListNode<T> prevNode = null;

        while (currentNode != null && !currentNode.getData().equals(data)) {
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (currentNode != null) {
            prevNode.setNext(currentNode.getNext());
            size--;
        }
    }

    public T removeFirst() { // remove and return the data of the first node in the linked list
        if (isEmpty()) {
            return null;
        }

        T firstData = head.getData();
        head = head.getNext();
        size--;
        return firstData;
    }

    public T get(int index) { // retrieve the data at the specified index in the linked list
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        LinkedListNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }

    public void display() {
        LinkedListNode<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }
}
