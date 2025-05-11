package Ejercicio3;

public class Test {
    public static void main(String[] args) throws ExceptionIsEmpty {
        // Crear la cola de prioridad con 3 niveles de prioridad
        PriorityQueueLinked<String, Integer> pq = new PriorityQueueLinked<>(3);

        // Encolar elementos con diferentes prioridades
        pq.enqueue("Baja", 1);       // Prioridad 1 (más baja)
        pq.enqueue("Media", 2);     // Prioridad 2
        pq.enqueue("Alta", 0);      // Prioridad 0 (más alta)
        
        // Imprimir el primer y último elemento
        System.out.println("Frente de la cola: " + pq.front());  // Alta
        System.out.println("Final de la cola: " + pq.back());    // Baja

        // Desencolar los elementos en orden de prioridad
        System.out.println("Desencolar: " + pq.dequeue());  // Alta
        System.out.println("Desencolar: " + pq.dequeue());  // Media
        System.out.println("Desencolar: " + pq.dequeue());  // Baja

        // Verificar si la cola está vacía
        System.out.println("¿Está la cola vacía? " + pq.isEmpty());  // true
    }
}
