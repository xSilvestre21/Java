package pjAula7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Robo {
	public static List<Produto> gerarLista() {
		List<Produto> listaGerada = new ArrayList<Produto>();
		int posicoes = new Random().nextInt(0, 1_000);
		long inicio = System.currentTimeMillis();
		
		for(int i = 0; i < posicoes; i++) {
			Produto p = new Produto();
			p.setCodigo(i);
			p.setDescricao("Produto " + i);
			p.setQuantidade(new Random().nextFloat());
			p.setStatus(true);
			
			listaGerada.add(p);
		}
		System.out.println("Levou " + (System.currentTimeMillis() - inicio));
		return listaGerada;
	}
}
