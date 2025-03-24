package Operaciones;

public class OperacionesMatBInteger implements Operable<OperacionesMatBInteger> {
    private Integer valor;

    public OperacionesMatBInteger(Integer valor) {
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }

    @Override
    public OperacionesMatBInteger sumar(OperacionesMatBInteger op) {
        return new OperacionesMatBInteger(this.valor + op.getValor());
    }

    @Override
    public OperacionesMatBInteger restar(OperacionesMatBInteger op) {
        return new OperacionesMatBInteger(this.valor - op.getValor());
    }

    @Override
    public OperacionesMatBInteger multiplicar(OperacionesMatBInteger op) {
        return new OperacionesMatBInteger(this.valor * op.getValor());
    }

    @Override
    public OperacionesMatBInteger dividir(OperacionesMatBInteger op) {
        if (op.getValor() == 0) throw new ArithmeticException("División entre cero");
        return new OperacionesMatBInteger(this.valor / op.getValor());
    }
}
