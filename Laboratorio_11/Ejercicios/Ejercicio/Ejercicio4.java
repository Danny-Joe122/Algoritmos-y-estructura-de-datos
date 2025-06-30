package Ejercicio;

import Hashclosed.HashC;
import Model.Register;

public class Ejercicio4 {
    public static void main(String[] args) {
        HashC tabla = new HashC(7);
        tabla.insert(new Register(5, "X"));
        tabla.insert(new Register(12, "Y"));
        tabla.insert(new Register(19, "Z"));

        tabla.delete(12);

        System.out.println("Buscar 19 tras eliminar 12: " + tabla.search(19));
        tabla.display();
    }
}
