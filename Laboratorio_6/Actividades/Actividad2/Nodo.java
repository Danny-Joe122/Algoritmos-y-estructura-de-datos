package Actividad2;

public class Node<E> {
    private E data;
    private Node<E> next;

    // Constructor para crear un nodo con el dato
    public Node(E data) {
        this.data = data;
        this.next = null;
    }

    // Métodos de acceso
    public E getData() {
        return data;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getNext() {
        return next;
    }
}
