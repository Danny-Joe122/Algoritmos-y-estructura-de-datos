package lab05.listaenlazada;

import java.util.List;
import java.util.ArrayList;

public class Utilidades {

    // 1. Buscar un elemento genérico en una lista
    public static <T> boolean buscarElemento(List<T> lista, T valor) {
        return lista.contains(valor);
    }

    // 2. Invertir una lista genérica
    public static <T> List<T> invertirLista(List<T> lista) {
        List<T> invertida = new ArrayList<>();
        for (int i = lista.size() - 1; i >= 0; i--) {
            invertida.add(lista.get(i));
        }
        return invertida;
    }

    // 3. Insertar un nodo al final
    public static <T> Node<T> insertarAlFinal(Node<T> head, T valor) {
        Node<T> nuevo = new Node<>(valor);
        if (head == null) {
            return nuevo;
        }
        Node<T> actual = head;
        while (actual.next != null) {
            actual = actual.next;
        }
        actual.next = nuevo;
        return head;
    }

    // 4. Contar los nodos
    public static <T> int contarNodos(Node<T> head) {
        int contador = 0;
        Node<T> actual = head;
        while (actual != null) {
            contador++;
            actual = actual.next;
        }
        return contador;
    }

    // 5. Comparar dos listas
    public static <T> boolean sonIguales(Node<T> a, Node<T> b) {
        while (a != null && b != null) {
            if (!a.data.equals(b.data)) {
                return false;
            }
            a = a.next;
            b = b.next;
        }
        return a == null && b == null;
    }

    // 6. Concatenar dos listas
    public static <T> Node<T> concatenarListas(Node<T> a, Node<T> b) {
        if (a == null) return b;
        Node<T> actual = a;
        while (actual.next != null) {
            actual = actual.next;
        }
        actual.next = b;
        return a;
    }
}
