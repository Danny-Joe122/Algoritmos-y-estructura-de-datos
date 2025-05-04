package lab05.listaenlazada;

public class GestorDeTareas<T> implements TDAList<T> {
    private Node<T> head;

    @Override
    public void agregarTarea(T tarea) {
        Node<T> nuevo = new Node<>(tarea);
        if (head == null) {
            head = nuevo;
        } else {
            Node<T> actual = head;
            while (actual.next != null) {
                actual = actual.next;
            }
            actual.next = nuevo;
        }
    }

    @Override
    public boolean eliminarTarea(T tarea) {
        if (head == null) return false;
        if (head.data.equals(tarea)) {
            head = head.next;
            return true;
        }

        Node<T> actual = head;
        while (actual.next != null) {
            if (actual.next.data.equals(tarea)) {
                actual.next = actual.next.next;
                return true;
            }
            actual = actual.next;
        }
        return false;
    }

    @Override
    public boolean contieneTarea(T tarea) {
        Node<T> actual = head;
        while (actual != null) {
            if (actual.data.equals(tarea)) return true;
            actual = actual.next;
        }
        return false;
    }

    @Override
    public void imprimirTareas() {
        Node<T> actual = head;
        while (actual != null) {
            System.out.println(actual.data);
            actual = actual.next;
        }
    }

    @Override
    public int contarTareas() {
        int contador = 0;
        Node<T> actual = head;
        while (actual != null) {
            contador++;
            actual = actual.next;
        }
        return contador;
    }

    @Override
    public void invertirTareas() {
        Node<T> prev = null;
        Node<T> actual = head;
        Node<T> next;

        while (actual != null) {
            next = actual.next;
            actual.next = prev;
            prev = actual;
            actual = next;
        }

        head = prev;
    }

    public T obtenerTareaMasPrioritaria() {
        if (head == null || !(head.data instanceof Tarea)) return null;

        Node<T> actual = head;
        Tarea mayor = (Tarea) actual.data;

        while (actual != null) {
            Tarea t = (Tarea) actual.data;
            if (t.getPrioridad() > mayor.getPrioridad()) {
                mayor = t;
            }
            actual = actual.next;
        }
        return (T) mayor;
    }

    public Node<T> getHead() {
        return head;
    }
}
