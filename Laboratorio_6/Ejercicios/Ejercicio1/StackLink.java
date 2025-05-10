package Ejercicio1;

public class StackLink<E> implements Stack<E> {
    private Node<E> top; // Apunta al elemento en la cima de la pila

    public StackLink() {
        this.top = null; // Pila vacía al inicio
    }

    // Inserta un elemento en la cima (top) de la pila
    @Override
    public void push(E x) {
        Node<E> newNode = new Node<>(x);
        newNode.setNext(top);
        top = newNode;
    }

    // Elimina el elemento en la cima y lo retorna
    @Override
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("No se puede desapilar una pila vacía.");
        }
        E data = top.getData();
        top = top.getNext();
        return data;
    }

    // Devuelve el elemento en la cima sin eliminarlo
    @Override
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía.");
        }
        return top.getData();
    }

    // Verifica si la pila está vacía
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    // Muestra los elementos desde la cima hasta el fondo
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cima -> ");
        Node<E> current = top;
        while (current != null) {
            sb.append(current.getData()).append(" -> ");
            current = current.getNext();
        }
        sb.append("null");
        return sb.toString();
    }
}
