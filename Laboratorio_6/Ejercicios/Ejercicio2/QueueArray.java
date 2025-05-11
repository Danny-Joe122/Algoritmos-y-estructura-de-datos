package Ejercicio2;

public class QueueArray<E> implements Queue<E> {
    private E[] array;
    private int front;
    private int rear;
    private int size;
    private int capacidad;

    @SuppressWarnings("unchecked")
    public QueueArray(int capacidad) {
        this.capacidad = capacidad;
        this.array = (E[]) new Object[capacidad];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    @Override
    public void enqueue(E x) {
        if (size == capacidad) {
            System.out.println("La cola está llena. No se puede encolar.");
            return;
        }
        array[rear] = x;
        rear = (rear + 1) % capacidad;
        size++;
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía.");
        E valor = array[front];
        array[front] = null; // Limpia referencia
        front = (front + 1) % capacidad;
        size--;
        return valor;
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía.");
        return array[front];
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía.");
        int idx = (rear - 1 + capacidad) % capacidad;
        return array[idx];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            int idx = (front + i) % capacidad;
            sb.append(array[idx]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
