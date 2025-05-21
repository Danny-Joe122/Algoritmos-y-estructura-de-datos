package Prueba;

import Ejercicios.LinkedBST;
import Exceptions.ExceptionIsEmpty;
import Exceptions.ItemDuplicated;
import Exceptions.ItemNoFound;

public class Prueba {

    public static void main(String[] args) {
        try {
            LinkedBST<Integer> arbol = new LinkedBST<>();

            arbol.insert(10);
            arbol.insert(5);
            arbol.insert(15);
            arbol.insert(3);
            arbol.insert(7);

            System.out.println("Árbol (drawBST):");
            arbol.drawBST();

            System.out.println("\nÁrbol (parenthesize):");
            arbol.parenthesize();

            System.out.println("\nCantidad total de nodos: " + arbol.countNodes());
            System.out.println("Cantidad nodos no hoja: " + arbol.countAllNodes());
            System.out.println("Altura del subárbol con raíz 5: " + arbol.height(5));
            System.out.println("Amplitud nivel 2: " + arbol.amplitude(2));
            System.out.println("Área del árbol: " + arbol.areaBST());

            System.out.println("¿Existe el 7? " + arbol.search(7));

            arbol.delete(5);
            System.out.println("\nÁrbol después de eliminar 5:");
            arbol.drawBST();

        } catch (ItemDuplicated | ExceptionIsEmpty | ItemNoFound e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
