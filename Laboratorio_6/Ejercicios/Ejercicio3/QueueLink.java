package Ejercicio3;

public class QueueLink<E> {
    private Node<E> first;
    private Node<E> last;

    public QueueLink() {
        this.first = null;
        this.last = null;
    }

    public void enqueue(E x) {
        Node<E> newNode = new Node<>(x);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("The queue is empty");
        }
        E data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("The queue is empty");
        }
        return first.data;
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("The queue is empty");
        }
        return last.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    // Getter para 'first'
    public Node<E> getFirst() {
        return first;
    }
}
