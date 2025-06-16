package Tree;

import Model.RegistroEstudiante;

import java.util.ArrayList;

public class BTree<E extends Comparable<E>> {
    private BNode<E> root;
    private int orden;
    private boolean up;
    private BNode<E> nDes;

    public BTree(int orden) {
        this.orden = orden;
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(E cl) {
        up = false;
        E mediana = push(root, cl);
        if (up) {
            BNode<E> pnew = new BNode<>(orden);
            pnew.count = 1;
            pnew.keys.set(0, mediana);
            pnew.childs.set(0, root);
            pnew.childs.set(1, nDes);
            root = pnew;
        }
    }

    private E push(BNode<E> current, E cl) {
        int[] pos = new int[1];
        if (current == null) {
            up = true;
            nDes = null;
            return cl;
        } else {
            boolean fl = current.searchNode(cl, pos);
            if (fl) {
                System.out.println("Item duplicado\n");
                up = false;
                return null;
            }
            E mediana = push(current.childs.get(pos[0]), cl);
            if (up) {
                if (current.nodeFull(orden - 1)) {
                    mediana = dividedNode(current, mediana, pos[0]);
                } else {
                    putNode(current, mediana, nDes, pos[0]);
                    up = false;
                }
                return mediana;
            }
            return null;
        }
    }

    private void putNode(BNode<E> current, E cl, BNode<E> rd, int k) {
        for (int i = current.count - 1; i >= k; i--) {
            current.keys.set(i + 1, current.keys.get(i));
            current.childs.set(i + 2, current.childs.get(i + 1));
        }
        current.keys.set(k, cl);
        current.childs.set(k + 1, rd);
        current.count++;
    }

    private E dividedNode(BNode<E> current, E cl, int k) {
        BNode<E> rd = nDes;
        int posMdna = (k <= orden / 2) ? orden / 2 : orden / 2 + 1;
        nDes = new BNode<>(orden);
        for (int i = posMdna; i < orden - 1; i++) {
            nDes.keys.set(i - posMdna, current.keys.get(i));
            nDes.childs.set(i - posMdna + 1, current.childs.get(i + 1));
        }
        nDes.count = (orden - 1) - posMdna;
        current.count = posMdna;
        if (k <= orden / 2)
            putNode(current, cl, rd, k);
        else
            putNode(nDes, cl, rd, k - posMdna);
        E median = current.keys.get(current.count - 1);
        nDes.childs.set(0, current.childs.get(current.count));
        current.count--;
        return median;
    }

    public boolean search(E cl) {
        return searchRec(root, cl);
    }

    private boolean searchRec(BNode<E> current, E cl) {
        if (current == null) return false;
        int[] pos = new int[1];
        boolean found = current.searchNode(cl, pos);
        if (found) {
            System.out.println(cl + " se encuentra en el nodo " + current.idNode + " en la posición " + pos[0]);
            return true;
        }
        return searchRec(current.childs.get(pos[0]), cl);
    }

    public String buscarNombre(int codigo) {
        return buscarNombreRec(root, codigo);
    }

    private String buscarNombreRec(BNode<E> current, int codigo) {
        if (current == null) return "No encontrado";
        for (int i = 0; i < current.count; i++) {
            RegistroEstudiante est = (RegistroEstudiante) current.keys.get(i);
            if (est.getCodigo() == codigo)
                return est.getNombre();
            else if (codigo < est.getCodigo())
                return buscarNombreRec(current.childs.get(i), codigo);
        }
        return buscarNombreRec(current.childs.get(current.count), codigo);
    }

    public void remove(E cl) {
        if (!delete(root, cl)) {
            System.out.println("Elemento no encontrado para eliminar: " + cl);
        } else {
            if (root.count == 0 && root.childs.get(0) != null) {
                root = root.childs.get(0); // reducir la altura
            }
        }
    }

    private boolean delete(BNode<E> node, E cl) {
        if (node == null) return false;
        int i = 0;
        while (i < node.count && cl.compareTo(node.keys.get(i)) > 0) i++;
        if (i < node.count && cl.compareTo(node.keys.get(i)) == 0) {
            if (node.childs.get(0) == null) {
                for (int j = i; j < node.count - 1; j++) {
                    node.keys.set(j, node.keys.get(j + 1));
                }
                node.keys.set(node.count - 1, null);
                node.count--;
                return true;
            } else {
                BNode<E> succ = node.childs.get(i + 1);
                while (succ.childs.get(0) != null) succ = succ.childs.get(0);
                E successor = succ.keys.get(0);
                node.keys.set(i, successor);
                return delete(node.childs.get(i + 1), successor);
            }
        } else {
            return delete(node.childs.get(i), cl);
        }
    }

    public String toString() {
        return isEmpty() ? "BTree is empty..." : writeTree(root);
    }

    private String writeTree(BNode<E> current) {
        if (current == null) return "";
        StringBuilder sb = new StringBuilder(current.toString()).append("\n");
        for (int i = 0; i <= current.count; i++) {
            sb.append(writeTree(current.childs.get(i)));
        }
        return sb.toString();
    }
}
