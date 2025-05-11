package Ejercicio3;

public class PriorityQueueLinked<E, N extends Comparable<N>> {

    // Clase interna EntryNode para almacenar el dato y la prioridad
    class EntryNode {
        E data;
        N priority;

        EntryNode(E data, N priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    // Lista de colas, una para cada prioridad
    private QueueLink<EntryNode>[] priorityQueues;

    // Constructor para inicializar las colas, basado en el número de prioridades
    public PriorityQueueLinked(int numPriorities) {
        this.priorityQueues = new QueueLink[numPriorities];
        for (int i = 0; i < numPriorities; i++) {
            this.priorityQueues[i] = new QueueLink<>();  // Inicializamos cada cola
        }
    }

    // Encolar un elemento con su prioridad
    public void enqueue(E x, N pr) {
        int priorityIndex = pr.compareTo(pr);  // Aquí debemos convertir la prioridad a un índice
        EntryNode newEntry = new EntryNode(x, pr);

        // Insertar el nodo en la cola correspondiente a su prioridad
        priorityQueues[priorityIndex].enqueue(newEntry);
    }

    // Desencolar el elemento con la mayor prioridad
    public E dequeue() throws ExceptionIsEmpty {
        for (int i = priorityQueues.length - 1; i >= 0; i--) {
            if (!priorityQueues[i].isEmpty()) {
                EntryNode node = (EntryNode) priorityQueues[i].dequeue();
                return node.data;
            }
        }
        throw new ExceptionIsEmpty("PriorityQueue is empty");
    }

    // Obtener el primer elemento sin eliminarlo
    public E front() throws ExceptionIsEmpty {
        for (int i = priorityQueues.length - 1; i >= 0; i--) {
            if (!priorityQueues[i].isEmpty()) {
                EntryNode node = (EntryNode) priorityQueues[i].front();
                return node.data;
            }
        }
        throw new ExceptionIsEmpty("PriorityQueue is empty");
    }

    // Obtener el último elemento sin eliminarlo
    public E back() throws ExceptionIsEmpty {
        for (int i = priorityQueues.length - 1; i >= 0; i--) {
            if (!priorityQueues[i].isEmpty()) {
                EntryNode node = (EntryNode) priorityQueues[i].back();
                return node.data;
            }
        }
        throw new ExceptionIsEmpty("PriorityQueue is empty");
    }

    // Verificar si la cola de prioridad está vacía
    public boolean isEmpty() {
        for (QueueLink<EntryNode> queue : priorityQueues) {
            if (!queue.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    // Método para mostrar el contenido de la cola de prioridad
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (QueueLink<EntryNode> queue : priorityQueues) {
            Node<EntryNode> temp = queue.getFirst();  // Usando el getter para acceder a 'first'
            while (temp != null) {
                sb.append(temp.data.data).append(" ");
                temp = temp.next;
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
