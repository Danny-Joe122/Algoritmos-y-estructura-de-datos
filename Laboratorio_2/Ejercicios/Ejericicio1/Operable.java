package Operaciones;

//E: Tipo genérico
public interface Operable<E> {
 E sumar(E op);
 E restar(E op);
 E multiplicar(E op);
 E dividir(E op);
}
