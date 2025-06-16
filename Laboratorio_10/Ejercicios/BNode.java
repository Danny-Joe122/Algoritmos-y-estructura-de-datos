package Tree;

import java.util.ArrayList;

public class BNode<E> {
    protected static int idCounter = 0;
    protected int idNode;
    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;
    protected int count;

    public BNode(int n) {
        this.idNode = idCounter++;
        this.keys = new ArrayList<>(n);
        this.childs = new ArrayList<>(n);
        this.count = 0;
        for (int i = 0; i < n; i++) {
            this.keys.add(null);
            this.childs.add(null);
        }
    }

    public boolean nodeFull(int max) {
        return count == max;
    }

    public boolean nodeEmpty() {
        return count == 0;
    }

    public boolean searchNode(E cl, int[] pos) {
        int i = 0;
        while (i < count && ((Comparable<E>) cl).compareTo(keys.get(i)) > 0) i++;
        pos[0] = i;
        return (i < count && ((Comparable<E>) cl).compareTo(keys.get(i)) == 0);
    }

    @Override
    public String toString() {
        return "Nodo ID: " + idNode + " Keys: " + keys;
    }
}
