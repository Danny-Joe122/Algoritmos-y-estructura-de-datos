package HashAbierto;

import Modelo.Register;
import java.util.LinkedList;

public class HashO {

    private LinkedList<Register>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashO(int size) {
        this.size = size;
        this.table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(Register reg) {
        int idx = hash(reg.getKey());
        table[idx].add(reg);
    }

    public Register search(int key) {
        int idx = hash(key);
        for (Register r : table[idx]) {
            if (r.getKey() == key) return r;
        }
        return null;
    }

    public void delete(int key) {
        int idx = hash(key);
        table[idx].removeIf(r -> r.getKey() == key);
    }

    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            if (table[i].isEmpty()) {
                System.out.println("vacío");
            } else {
                for (Register r : table[i]) {
                    System.out.print(r + " ");
                }
                System.out.println();
            }
        }
    }
}
