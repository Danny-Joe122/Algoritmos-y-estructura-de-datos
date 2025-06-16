package Btree;

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
        return this.root == null;
    }

    // Método para insertar una clave en el árbol
    public void insert(E cl) {
        up = false;
        E mediana;
        BNode<E> pnew;
        mediana = push(this.root, cl);
        if (up) {
            pnew = new BNode<E>(this.orden);
            pnew.count = 1;
            pnew.keys.set(0, mediana);
            pnew.childs.set(0, this.root);
            pnew.childs.set(1, nDes);
            this.root = pnew;
        }
    }

    private E push(BNode<E> current, E cl) {
        int[] pos = new int[1];
        E mediana;
        if (current == null) {
            up = true;
            nDes = null;
            return cl;
        } else {
            boolean fl = searchNode(current, cl, pos);
            if (fl) {
                System.out.println("Item duplicado\n");
                up = false;
                return null;
            }
            mediana = push(current.childs.get(pos[0]), cl);
            if (up) {
                if (current.nodeFull(this.orden - 1)) {
                    mediana = dividedNode(current, mediana, pos[0]);
                }
            }
            up = false;
            putNode(current, mediana, nDes, pos[0]);
            return mediana;
        }
    }

    // Método de búsqueda pública
    public boolean search(E key) {
        return searchNode(this.root, key, new int[1]);
    }

    // Método para realizar la búsqueda en un nodo
    private boolean searchNode(BNode<E> current, E key, int[] pos) {
        if (current == null) return false;

        // Buscar en el nodo
        for (int i = 0; i < current.count; i++) {
            if (current.keys.get(i).equals(key)) {
                return true;  // Clave encontrada
            }
        }
        // Si no se encuentra, buscar en el hijo correspondiente
        for (int i = 0; i < current.count; i++) {
            if (((Comparable<E>) current.keys.get(i)).compareTo(key) > 0) {
                return searchNode(current.childs.get(i), key, pos);
            }
        }
        return searchNode(current.childs.get(current.count), key, pos);
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
        int posMdna = (k <= this.orden / 2) ? this.orden / 2 : this.orden / 2 + 1;
        nDes = new BNode<E>(this.orden);
        for (int i = posMdna; i < this.orden - 1; i++) {
            nDes.keys.set(i - posMdna, current.keys.get(i));
            nDes.childs.set(i - posMdna + 1, current.childs.get(i + 1));
        }
        nDes.count = (this.orden - 1) - posMdna;
        current.count = posMdna;
        if (k <= this.orden / 2)
            putNode(current, cl, rd, k);
        else
            putNode(nDes, cl, rd, k - posMdna);
        E median = current.keys.get(current.count - 1);
        nDes.childs.set(0, current.childs.get(current.count));
        current.count--;
        return median;
    }

    // Método toString para representar el árbol B
    public String toString() {
        String s = "";
        if (isEmpty()) {
            s += "BTree is empty...";
        } else {
            s = writeTree(this.root);
        }
        return s;
    }

    // Método recursivo para recorrer el árbol y construir la cadena
    private String writeTree(BNode<E> current) {
        StringBuilder sb = new StringBuilder();
        if (current != null) {
            sb.append(current.toString()).append("\n");
            for (BNode<E> child : current.childs) {
                sb.append(writeTree(child));
            }
        }
        return sb.toString();
    }
}
