package br.unisal.colecoes;

import java.util.Collection;
import java.util.HashSet;

public class ExemploSet {
	public static void main(String[] args) {
		Collection c = new HashSet(); // Ordem por Hash
		
		Produto produto = new Produto(1234, "Sabão");
		Produto produtoA = new Produto(4561, "ProdutoA");
		
		c.add(produto);
		c.add(produtoA);
		
		System.out.println(c);
	}
}
