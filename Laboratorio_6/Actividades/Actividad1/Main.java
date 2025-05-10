package Actividad1;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> pila = new StackArray<>(5); // Pila de enteros

        // Insertar elementos
        pila.push(10);
        pila.push(20);
        pila.push(30);

        // Mostrar pila
        System.out.println("Pila actual: " + pila);

        try {
            System.out.println("Elemento en la cima: " + pila.top());
            System.out.println("Elemento eliminado (pop): " + pila.pop());
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Pila después del pop: " + pila);
    }
}
