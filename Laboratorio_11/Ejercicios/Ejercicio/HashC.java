package Hashclosed;

import Model.Register;

public class HashC {
    private Register[] table;
    private int size;

    public HashC(int size) {
        this.size = size;
        table = new Register[size];
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(Register reg) {
        int pos = hash(reg.getKey());
        int originalPos = pos;

        while (table[pos] != null && !table[pos].isDeleted()) {
            pos = (pos + 1) % size;
            if (pos == originalPos) {
                System.out.println("Tabla llena");
                return;
            }
        }
        table[pos] = reg;
    }

    public Register search(int key) {
        int pos = hash(key);
        int originalPos = pos;

        while (table[pos] != null) {
            if (!table[pos].isDeleted() && table[pos].getKey() == key) {
                return table[pos];
            }
            pos = (pos + 1) % size;
            if (pos == originalPos) break;
        }
        return null;
    }

    public void delete(int key) {
        Register reg = search(key);
        if (reg != null) {
            reg.setDeleted(true);
        }
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ": " + (table[i] != null ? table[i] : "[empty]"));
        }
    }
}
