package bstreeInterface;

import Exceptions.ExceptionIsEmpty;
import Exceptions.ItemDuplicated;
import Exceptions.ItemNoFound;

public interface BinarySearchTree<E extends Comparable<E>> {

    void insert(E data) throws ItemDuplicated;
    void delete(E data) throws ExceptionIsEmpty, ItemNoFound;
    boolean search(E data) throws ExceptionIsEmpty, ItemNoFound;

    void destroyNodes() throws ExceptionIsEmpty;

    int countAllNodes() throws ExceptionIsEmpty;
    int countNodes() throws ExceptionIsEmpty;
    int height(E x) throws ExceptionIsEmpty, ItemNoFound;
    int amplitude(int nivel) throws ExceptionIsEmpty;
    int areaBST() throws ExceptionIsEmpty;

    void drawBST();

    boolean sameArea(BinarySearchTree<E> other) throws ExceptionIsEmpty;

    void parenthesize();
}
