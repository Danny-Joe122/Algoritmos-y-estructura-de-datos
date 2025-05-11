package Ejercicio4;

//Clase StackLink (implementación de una pila usando lista enlazada)
class StackLink<E> {
 private Node<E> top;

 public StackLink() {
     top = null;
 }

 // Método para agregar un elemento a la pila
 public void push(E item) {
     Node<E> newNode = new Node<>(item);
     newNode.setNext(top);
     top = newNode;
 }

 // Método para quitar el elemento de la cima de la pila
 public E pop() throws Exception {
     if (isEmpty()) {
         throw new Exception("Pila vacía");
     }
     E data = top.getData();
     top = top.getNext();
     return data;
 }

 // Método para ver el elemento de la cima de la pila sin quitarlo
 public E peek() throws Exception {
     if (isEmpty()) {
         throw new Exception("Pila vacía");
     }
     return top.getData();
 }

 // Verificar si la pila está vacía
 public boolean isEmpty() {
     return top == null;
 }

 // Nodo de la lista enlazada
 static class Node<E> {
     private E data;
     private Node<E> next;

     public Node(E data) {
         this.data = data;
         this.next = null;
     }

     public E getData() {
         return data;
     }

     public void setNext(Node<E> next) {
         this.next = next;
     }

     public Node<E> getNext() {
         return next;
     }
 }
}
