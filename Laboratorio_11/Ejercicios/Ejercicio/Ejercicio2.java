package Ejercicio;

public class Ejercicio2 {
    public static void main(String[] args) {
        Integer[] tabla = new Integer[6];
        int[] valores = {12, 18, 24, 30};
        for (int v : valores) {
            int pos = v % 6;
            while (tabla[pos] != null) {
                pos = (pos + 1) % 6;
            }
            tabla[pos] = v;
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(i + ": " + (tabla[i] != null ? tabla[i] : "[empty]"));
        }
    }
}
