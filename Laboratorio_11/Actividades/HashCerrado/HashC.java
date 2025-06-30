package Hashcerrado;

import Modelo.Register;

public class HashC {

    private static class Element {
        Register register;
        boolean isAvailable;

        public Element() {
            this.register = null;
            this.isAvailable = true;
        }
    }

    private Element[] table;
    private int size;

    public HashC(int size) {
        this.size = size;
        this.table = new Element[size];
        for (int i = 0; i < size; i++) {
            table[i] = new Element();
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(Register reg) {
        int idx = hash(reg.getKey());
        int startIdx = idx;
        do {
            if (table[idx].isAvailable) {
                table[idx].register = reg;
                table[idx].isAvailable = false;
                return;
            }
            idx = (idx + 1) % size;
        } while (idx != startIdx);
        System.out.println("Tabla llena, no se pudo insertar: " + reg);
    }

    public Register search(int key) {
        int idx = hash(key);
        int startIdx = idx;
        do {
            if (!table[idx].isAvailable && table[idx].register.getKey() == key) {
                return table[idx].register;
            }
            idx = (idx + 1) % size;
        } while (idx != startIdx);
        return null;
    }

    public void delete(int key) {
        int idx = hash(key);
        int startIdx = idx;
        do {
            if (!table[idx].isAvailable && table[idx].register.getKey() == key) {
                table[idx].isAvailable = true;
                return;
            }
            idx = (idx + 1) % size;
        } while (idx != startIdx);
    }

    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            if (!table[i].isAvailable) {
                System.out.println(table[i].register);
            } else {
                System.out.println("vacío");
            }
        }
    }
}
