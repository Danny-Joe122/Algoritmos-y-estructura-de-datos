package Btree;

import java.util.ArrayList;
import java.util.Collections;

public class BNode<E> {
    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;
    protected int count;
    protected static int idCounter = 0;
    protected int idNode;

    // Constructor de BNode
    public BNode(int n) {
        this.keys = new ArrayList<>(Collections.nCopies(n, null)); // Usar valores predeterminados
        this.childs = new ArrayList<>(Collections.nCopies(n + 1, null)); // Un hijo más que claves
        this.count = 0;
        this.idNode = idCounter++;
    }

    // Verifica si el nodo está lleno
    public boolean nodeFull(int maxKeys) {
        return this.count == maxKeys;
    }

    // Verifica si el nodo está vacío
    public boolean nodeEmpty() {
        return this.count == 0;
    }

    // Busca una clave en el nodo, retorna la posición y si se encuentra
    public boolean searchNode(E key, int[] pos) {
        for (int i = 0; i < count; i++) {
            if (keys.get(i).equals(key)) {
                pos[0] = i;
                return true;  // Clave encontrada
            }
        }
        // Si no se encuentra, encontrar la posición para insertar
        for (int i = 0; i < count; i++) {
            if (((Comparable<E>) keys.get(i)).compareTo(key) > 0) {
                pos[0] = i;
                return false;
            }
        }
        pos[0] = count;
        return false;
    }

    // Método para representar el nodo en forma de cadena
    public String toString() {
        return "Node " + idNode + ": " + keys.toString();
    }
}
