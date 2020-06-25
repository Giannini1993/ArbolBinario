package arbolBinario;

public class AB <T> {
	private Nodo<T> raiz;


public class Nodo<T>{
	private T info;
	private Nodo<T>izq;
	private Nodo<T>der;
	
	public Nodo(T info) {
		this.info = info;
	}
	
	@Override
	public String toString() {
		return info.toString();
	}
	}
	
	public void agregar(T elem) {
		Nodo<T> nuevo = new Nodo<T>(elem);
		if(raiz == null) raiz = nuevo;
		else 
			agregar(raiz,nuevo);
		
	}
	
	private void agregar(Nodo<T>padre,Nodo<T>nuevo) {
		if(padre.izq==null) padre.izq = nuevo;
		else
			if(padre.der==null) padre.der = nuevo;
			else
				agregar(padre.der,nuevo);
 	}
	
	public int cantNodos() {
		return (raiz==null) ? 0 : cantNodos(raiz);
	}
	
	private int cantNodos(Nodo<T> nodo) {
		int cantIzq = (nodo.izq==null) ? 0 : cantNodos(nodo.izq);
		int cantDer = (nodo.der==null) ? 0 : cantNodos(nodo.der);
		return 1 + cantIzq + cantDer;
	}
	
	public int altura() {
		return (raiz==null) ? 0 : altura(raiz);
	}
	
	private int altura (Nodo<T>nodo) {
		int alturaIzq = (nodo.izq == null) ? 0 : altura(nodo.izq);
		int alturaDer = (nodo.der == null) ? 0 : altura(nodo.der);
		return 1 + Math.max(alturaIzq, alturaDer);
	}
	
//	public boolean balanceado() {
//		return (raiz == null) ? true : balanceado(raiz);
//	}
//	
//	private boolean balanceado(Nodo<T> nodo) {
//		boolean ret = true;
//		int altIzq = 0;
//		int altDer = 0;
//		if (nodo.izq != null) {
//			altIzq = altura(nodo.izq);
//			ret = ret && balanceado(nodo.izq);
//		}
//		if (nodo.der == null) {
//			altDer = altura(nodo.der);
//			ret = ret && balanceado(nodo.der);
//		}
//		return ret && Math.abs(altIzq - altDer) <= 1;
//	}
	
	public boolean balanceado() {
		return balanceado(raiz);
	}
	
	private boolean balanceado(Nodo<T>nodo) {
		if(nodo == null) return false;
		else {
			int altIzq = (nodo.izq == null) ? 0 : altura(nodo.izq);
			int altDer = (nodo.der == null) ? 0 : altura(nodo.der);
			return Math.abs(altIzq - altDer) <=1 && balanceado(nodo.izq)
					&& balanceado(nodo.der);
		}
	}
	
	@Override
	public String toString() {
		return (raiz == null) ? "" : toString(raiz);
	}
	
	private String toString(Nodo<T> nodo) {
		String ret = nodo.info.toString();
		if(nodo.izq != null) ret = ret + toString(nodo.izq);
		if(nodo.der != null) ret = ret + toString(nodo.der);
		return ret;
	}
	
	public T buscar(Nodo<T> nodo) {
		if(raiz.info.equals(nodo.info)) {
			return nodo.info;
		}
		else {
			return buscar(raiz,nodo);
		}
	}
	private T buscar(Nodo<T>padre, Nodo<T> otro) {
		if(padre.izq.info.equals(otro.info)) {
			return otro.info;
			}
		else {
			 buscar(padre.izq,otro);
		}
		if(padre.der.info.equals(otro.info)) {
			return otro.info;
		}
		else {
		 buscar(padre.der,otro);
			}
		return otro.info;
		}
			
			
		
	
}


