package Ejercicio;

public class Ejercicio1 {
    public static void main(String[] args) {
        Integer[] tabla = new Integer[7];
        int[] valores = {3, 10, 17, 24};
        for (int v : valores) {
            tabla[v % 7] = v;
        }
        for (int i = 0; i < 7; i++) {
            System.out.println(i + ": " + (tabla[i] != null ? tabla[i] : "[empty]"));
        }
    }
}
