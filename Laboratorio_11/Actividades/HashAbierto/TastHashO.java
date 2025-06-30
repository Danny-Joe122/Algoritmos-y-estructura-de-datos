package HashAbierto;

import Modelo.Register;

public class TestHashO {
    public static void main(String[] args) {
        HashO tabla = new HashO(5);

        tabla.insert(new Register(10, "Juan"));
        tabla.insert(new Register(15, "Ana"));
        tabla.insert(new Register(20, "Luis"));
        tabla.insert(new Register(25, "Rosa"));
        tabla.insert(new Register(10, "Pedro"));
        
        System.out.println("\nTabla después de insertar:");
        tabla.printTable();

        Register encontrado = tabla.search(20);
        System.out.println("\nBuscar clave 20: " + (encontrado != null ? encontrado : "no encontrado"));

        Register noEncontrado = tabla.search(30);
        System.out.println("Buscar clave 30: " + (noEncontrado != null ? noEncontrado : "no encontrado"));

        tabla.delete(15);
        System.out.println("\nTabla después de eliminar clave 15:");
        tabla.printTable();
    }
}
