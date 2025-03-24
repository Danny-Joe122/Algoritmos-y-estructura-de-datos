package Operaciones;

public class OperacionesMatDouble implements Operable<OperacionesMatDouble> {
    private Double valor;

    public OperacionesMatDouble(Double valor) {
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }

    @Override
    public OperacionesMatDouble sumar(OperacionesMatDouble op) {
        return new OperacionesMatDouble(this.valor + op.getValor());
    }

    @Override
    public OperacionesMatDouble restar(OperacionesMatDouble op) {
        return new OperacionesMatDouble(this.valor - op.getValor());
    }

    @Override
    public OperacionesMatDouble multiplicar(OperacionesMatDouble op) {
        return new OperacionesMatDouble(this.valor * op.getValor());
    }

    @Override
    public OperacionesMatDouble dividir(OperacionesMatDouble op) {
        if (op.getValor() == 0.0) throw new ArithmeticException("División entre cero");
        return new OperacionesMatDouble(this.valor / op.getValor());
    }
}
