package ModaSolucion3;

import java.util.*;

public class ModaSolucion3 {

    public static int moda3(int[] array) {
        return divideYVenceras(array, 0, array.length - 1);
    }

    private static int divideYVenceras(int[] array, int start, int end) {
        if (start == end) return array[start];

        int mid = (start + end) / 2;
        int leftModa = divideYVenceras(array, start, mid);
        int rightModa = divideYVenceras(array, mid + 1, end);

        int leftCount = contar(array, start, end, leftModa);
        int rightCount = contar(array, start, end, rightModa);

        return (leftCount > rightCount) ? leftModa : rightModa;
    }

    private static int contar(int[] array, int start, int end, int value) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (array[i] == value)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arreglo = {2, 5, 3, 2, 2, 3, 5, 3, 3, 3};
        System.out.println("Moda (Solución 3): " + moda3(arreglo));
    }
}
