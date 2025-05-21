package Prueba;

import bstreelinklistinterfgeneric.LinkedBST;
import Exceptions.ExceptionIsEmpty;
import Exceptions.ItemDuplicated;
import Exceptions.ItemNoFound;

public class Prueba {

    public static void main(String[] args) {
        try {
            LinkedBST<Integer> arbol = new LinkedBST<>();

            // Insertar datos
            arbol.insert(10);
            arbol.insert(5);
            arbol.insert(15);
            arbol.insert(3);
            arbol.insert(7);
            arbol.insert(12);
            arbol.insert(17);

            System.out.println("Árbol dibujado (drawBST):");
            arbol.drawBST();

            System.out.println("\nRepresentación con parenthesize:");
            arbol.parenthesize();

            System.out.println("\nCantidad total de nodos: " + arbol.countNodes());
            System.out.println("Cantidad de nodos no hoja: " + arbol.countAllNodes());

            System.out.println("Altura del subárbol con raíz 5: " + arbol.height(5));
            System.out.println("Amplitud (número de nodos) en nivel 2: " + arbol.amplitude(2));
            System.out.println("Área del árbol (hojas * altura): " + arbol.areaBST());

            // Buscar un dato
            System.out.println("¿Existe el 7 en el árbol? " + arbol.search(7));

            // Eliminar un dato
            arbol.delete(5);
            System.out.println("\nÁrbol después de eliminar 5:");
            arbol.drawBST();

        } catch (ItemDuplicated e) {
            System.out.println("Error al insertar: " + e.getMessage());
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ItemNoFound e) {
            System.out.println("Error de búsqueda: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
