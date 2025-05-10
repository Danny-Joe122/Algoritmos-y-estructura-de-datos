package Ejercicio1;

public class Test {
    public static void main(String[] args) {
        try {
            Stack<Integer> pilaInt = new StackLink<>();
            pilaInt.push(10);
            pilaInt.push(20);
            pilaInt.push(30);
            System.out.println("Pila actual: " + pilaInt);
            System.out.println("Tope: " + pilaInt.top());
            System.out.println("Pop: " + pilaInt.pop());
            System.out.println("Pila luego de pop: " + pilaInt);

            Stack<String> pilaStr = new StackLink<>();
            pilaStr.push("Hola");
            pilaStr.push("Mundo");
            System.out.println("Pila de Strings: " + pilaStr);

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
