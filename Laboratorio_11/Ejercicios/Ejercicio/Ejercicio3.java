package Ejercicio;

import Hashopen.HashO;
import Model.Register;

public class Ejercicio3 {
    public static void main(String[] args) {
        HashO tabla = new HashO(5);
        tabla.insert(new Register(10, "Juan"));
        tabla.insert(new Register(15, "Ana"));
        tabla.insert(new Register(20, "Luis"));
        tabla.insert(new Register(25, "Rosa"));

        System.out.println("Buscar 20: " + tabla.search(20));
        System.out.println("Buscar 30: " + tabla.search(30));
    }
}
