package ModaSolucion1;

public class ModaSolucion1 {

    // Método principal para encontrar la moda
    public static int moda1(int[] array) {
        int first = 0;
        int end = array.length - 1;

        if (first == end) // Si el arreglo tiene un solo elemento
            return array[first];

        int moda = array[first];
        int maxrec = frecuencia(array, first, end, moda);

        for (int i = first + 1; i <= end; i++) {
            int frec = frecuencia(array, i, end, array[i]);
            if (frec > maxrec) {
                maxrec = frec;
                moda = array[i];
            }
        }

        return moda;
    }

    // Función que cuenta cuántas veces aparece 'ele' entre posiciones first y end
    private static int frecuencia(int[] array, int first, int end, int ele) {
        if (first > end)
            return 0;

        int suma = 0;
        for (int i = first; i <= end; i++) {
            if (array[i] == ele)
                suma++;
        }
        return suma;
    }

    // Método main para probar la solución
    public static void main(String[] args) {
        int[] arreglo = {2, 5, 3, 2, 2, 3, 5, 5, 5, 5};
        int moda = moda1(arreglo);
        System.out.println("La moda del arreglo es: " + moda);
    }
}
