package ModaSolucion2;

import java.util.Arrays;

public class ModaSolucion2 {

    public static int moda2(int[] array) {
        Arrays.sort(array); // Necesitamos el arreglo ordenado

        int moda = array[0];
        int maxCount = 1;
        int count = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count > maxCount) {
                maxCount = count;
                moda = array[i];
            }
        }

        return moda;
    }

    public static void main(String[] args) {
        int[] arreglo = {2, 5, 3, 2, 2, 3, 6, 6, 6, 6};
        System.out.println("Moda (Solución 2): " + moda2(arreglo));
    }
}
