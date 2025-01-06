package br.unisal.colecoes;

import java.util.Collection;
import java.util.TreeSet;

public class ExemploSet2 {
	public static void main(String[] args) {
		Collection c = new TreeSet(); //Ordem alfabetica

		c.add("Ana");
		c.add("Roger");
		c.add("Gustavo");
		c.add("Maria");
		c.add("Madalena");
		c.add("Rogerio");
		c.add("Lucas");
		
		System.out.println(c);
	}
}