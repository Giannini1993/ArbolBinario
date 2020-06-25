package arbolBinario;

import java.util.ArrayList;
import java.util.List;



public class ABB<T extends Comparable<T>> {
	private Nodo<T> raiz;
	
	public static class Nodo<T extends Comparable<T>>{
		private T info;
		private Nodo<T> izq;
		private Nodo<T> der;
		
		public Nodo(T info) {
			this.info = info;
		}
		
		@Override
		public String toString() {
			return info.toString();
		}
	}
	
	public Nodo<T> obtener(T elemento){
		if(raiz == null) {
			return null;
		}
		else {
			return obtener(raiz,elemento);
		}
	}
	
	private Nodo<T> obtener(Nodo<T>nodo, T elemento){
		if(nodo == null || nodo.info.equals(elemento)) {
			return nodo;
		}
		if(elemento.compareTo(nodo.info) < 0) {
			return obtener(nodo.izq,elemento);
		}
		else {
			return obtener(nodo.der,elemento);
		}
	}
	
	public void agregar(T elemento) {
		Nodo<T> nuevo = new Nodo(elemento);
		if(raiz == null) {
			raiz = nuevo;
		}
		else {
			agregar(raiz, nuevo);
		}
	}
	
	private Nodo<T> agregar(Nodo<T> nodo, Nodo<T> elemento) {
		if(nodo == null) {
			return elemento;
		}
		else {
			if(elemento.info.compareTo(nodo.info)<0) {
				nodo.izq = agregar(nodo.izq,elemento);
			}
			else {
				nodo.der = agregar(nodo.der,elemento);
			}
		}
		return nodo;
	}
	
	public boolean balanceado() {
		return balanceado(raiz);
	}
	
	private boolean balanceado(Nodo<T>nodo) {
		if(nodo == null) {
			return true;
		}
		else {
			return (Math.abs(altura(nodo.izq)-altura(nodo.der)) <= 1)
					&& balanceado(nodo.izq) && balanceado(nodo.der);
		}
	}
	
	public int altura() {
		return altura(raiz);
	}
	
	private int altura(Nodo<T>nodo) {
		if(nodo == null) {
			return 0;
		}
		else {
			return 1+ Math.max(altura(nodo.izq), altura(nodo.der));
		}
	}
	
	public int cantidadNodos() {
		return cantidadNodos(raiz);
	}
	
	private int cantidadNodos(Nodo<T> nodo) {
		if(nodo == null) {
			return 0;
		}
		else {
			return 1 + cantidadNodos(nodo.izq) + cantidadNodos(nodo.der);
		}
	}
	
	public List inorden() {
		List<T> ordenados = new ArrayList<T>();
		if (ordenados == null) {
			return ordenados;
		}
		else {
			return inorden(raiz,ordenados);
		}
	}
	
	private List<T> inorden(Nodo<T> nodo, java.util.List<T>ordenado){
		if(nodo != null) {
			inorden(nodo.izq,ordenado);
			ordenado.add(nodo.info);
			inorden(nodo.der,ordenado);
			return ordenado;
		}
		return ordenado;
			
	}
	
	public Integer sumar() {
		if(raiz==null) {
			return 0;
		}
		else {
		return sumar(raiz);
		}
	}
	
	private Integer sumar(Nodo<T> nodo) {
		int suma =0;
		if(nodo != null ) {
			sumar( nodo.izq);
			suma = suma + (int)nodo.info;
			sumar(nodo.der);
			return suma;
		}
		else {
			return suma;
		}
	}
		
	

}
