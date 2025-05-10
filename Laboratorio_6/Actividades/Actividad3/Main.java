package Actividad3;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<String, Integer> cola = new PriorityQueueLinkSort<>();

        cola.enqueue("Correo urgente", 5);
        cola.enqueue("Revisión de código", 3);
        cola.enqueue("Llamada del jefe", 4);
        cola.enqueue("Tarea diaria", 2);

        System.out.println("Cola de prioridad: " + cola);

        try {
            System.out.println("Elemento con mayor prioridad: " + cola.front());
            System.out.println("Eliminado: " + cola.dequeue());
            System.out.println("Cola actual: " + cola);
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
