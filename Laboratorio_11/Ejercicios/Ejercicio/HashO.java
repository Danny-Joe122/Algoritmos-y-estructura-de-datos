package Hashopen;

import Model.Register;
import java.util.LinkedList;

public class HashO {
    private LinkedList<Register>[] table;
    private int size;

    public HashO(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(Register reg) {
        int pos = hash(reg.getKey());
        table[pos].add(reg);
    }

    public Register search(int key) {
        int pos = hash(key);
        for (Register reg : table[pos]) {
            if (reg.getKey() == key) return reg;
        }
        return null;
    }

    public void delete(int key) {
        int pos = hash(key);
        table[pos].removeIf(r -> r.getKey() == key);
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            for (Register r : table[i]) {
                System.out.print("[" + r + "] ");
            }
            System.out.println();
        }
    }
}
