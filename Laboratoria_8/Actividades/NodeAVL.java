package Actividad;

//Nodo AVL con factor de equilibrio y referencias a hijos
public class NodeAVL<E> {
	protected E data;
	protected int bf; // factor de equilibrio
	protected NodeAVL<E> left;
	protected NodeAVL<E> right;

	public NodeAVL(E data) {
		this.data = data;
		this.bf = 0;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return data + " (bf=" + bf + ")";
	}
}
