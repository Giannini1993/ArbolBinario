package arbolBinario;

import arbolBinario.AB.Nodo;

public class Test {

	public static void main(String[] args) {
//		AB arbol = new AB();
//		arbol.agregar(4);
//		arbol.agregar(5);
//		arbol.agregar(6);
//		arbol.agregar(7);
//		arbol.agregar(8);
//		arbol.agregar(10);
//		arbol.agregar(12);
//		System.out.println(arbol.cantNodos());
//		System.out.println(arbol.altura());
//		System.out.println(arbol.balanceado());
//		System.out.println(arbol.toString());
		
		ABB arbolBinario = new ABB();
		arbolBinario.agregar(7);
		arbolBinario.agregar(4);
		arbolBinario.agregar(9);
		arbolBinario.agregar(19);
		arbolBinario.agregar(2);
		arbolBinario.agregar(6);
		System.out.println(arbolBinario.sumar());
		
	}

}
