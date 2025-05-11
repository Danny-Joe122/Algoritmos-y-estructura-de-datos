package Ejercicio4;

public class Application {

    // Método para verificar si los corchetes están bien anidados
    public static boolean symbolBalancing(String str) {
        StackLink<Character> stack = new StackLink<>();

        // Iterar sobre cada caracter de la cadena
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Si es un corchete de apertura, apílalo
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            // Si es un corchete de cierre, verifica si hace match con el de apertura
            else if (ch == ')' || ch == ']' || ch == '}') {
                try {
                    char top = stack.pop();

                    // Verificar si el corchete de cierre corresponde con el de apertura
                    if ((ch == ')' && top != '(') ||
                        (ch == ']' && top != '[') ||
                        (ch == '}' && top != '{')) {
                        return false;  // No está balanceado
                    }
                } catch (Exception e) {
                    return false;  // Intento de pop desde una pila vacía
                }
            }
        }

        // Si la pila está vacía, es válido (todos los corchetes se emparejaron)
        return stack.isEmpty();
    }

    // Método main para realizar pruebas de la función symbolBalancing
    public static void main(String[] args) {
        // Definir las combinaciones de corchetes y su respectiva evaluación
        String[] sequences = {
            "()()()[()]()",    // Combinación 1
            "((()))[]",        // Combinación 2
            "([])[](",         // Combinación 3
            "([{)]}",          // Combinación 4
            "[",               // Combinación 5
            "[][][]{{{}}}"     // Combinación 6
        };

        // Iterar sobre cada secuencia, evaluar y mostrar el resultado
        for (String seq : sequences) {
            boolean result = symbolBalancing(seq);
            System.out.println("Secuencia: " + seq + " -> " + result);
        }
    }
}
