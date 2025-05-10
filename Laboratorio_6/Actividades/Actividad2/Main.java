package Actividad2;

public class Test {
    public static void main(String[] args) {
        // Crear una cola de prioridad con Strings
        Queue<String> cola = new QueueLink<>();

        // Insertar elementos en la cola
        cola.enqueue("Arequipa");
        cola.enqueue("Cusco");
        cola.enqueue("Puno");

        // Mostrar la cola
        System.out.println("Cola actual: " + cola);

        try {
            // Ver el primer y último elemento sin eliminarlo
            System.out.println("Frente de la cola: " + cola.front());
            System.out.println("Último de la cola: " + cola.back());

            // Eliminar el primer elemento y mostrar la cola
            System.out.println("Elemento eliminado: " + cola.dequeue());
            System.out.println("Cola después de eliminar: " + cola);
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
