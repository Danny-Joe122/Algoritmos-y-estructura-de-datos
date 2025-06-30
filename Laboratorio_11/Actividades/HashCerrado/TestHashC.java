package Hashcerrado;

import Modelo.Register;

public class TestHashC {
    public static void main(String[] args) {
        HashC tabla = new HashC(11);

        Register[] datos = {
            new Register(34, "Ana"),
            new Register(3, "Luis"),
            new Register(7, "Marta"),
            new Register(30, "Juan"),
            new Register(11, "Pedro"),
            new Register(8, "Laura"),
            new Register(7, "Carlos"),
            new Register(23, "Sofía"),
            new Register(41, "Elena"),
            new Register(16, "Raúl"),
            new Register(34, "Andrea")
        };

        for (Register r : datos) {
            tabla.insert(r);
        }

        System.out.println("\nTabla antes de eliminar:");
        tabla.printTable();

        tabla.delete(30);
        System.out.println("\nTabla después de eliminar clave 30:");
        tabla.printTable();

        Register buscado = tabla.search(23);
        System.out.println("\nBuscar clave 23: " + (buscado != null ? buscado : "no encontrado"));
    }
}
