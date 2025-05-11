package Ejercicio2;

public class Test {
    public static void main(String[] args) {
        Queue<String> cola = new QueueArray<>(5);

        cola.enqueue("Juan");
        cola.enqueue("Ana");
        cola.enqueue("Luis");
        cola.enqueue("Marta");

        System.out.println("Cola: " + cola);

        try {
            System.out.println("Frente: " + cola.front());
            System.out.println("Último: " + cola.back());

            System.out.println("Eliminado: " + cola.dequeue());
            System.out.println("Cola luego de dequeue: " + cola);

            cola.enqueue("Carlos");
            cola.enqueue("Pedro"); // debería completar la cola
            System.out.println("Cola final: " + cola);

            cola.enqueue("Extra"); // esta debería ser ignorada porque está llena

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
