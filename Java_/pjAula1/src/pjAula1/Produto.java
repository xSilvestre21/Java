package pjAula1;

/**
 *  @author Gustavo Silvestre
 *  @data 06/01/2024
 *  Classe de Modelagem conceitual de produto
 *  */
public class Produto {
	// Atributos
	int codigo;
	String descricao;
	float quantidade;
	
	// Metodos
	public void incluir(int id, String nome, float valor) {
		codigo = id;
		descricao = nome;
		quantidade = valor;
	}
	
	public static void main(String[] args) {
		System.out.println("Olá, mundo!");
		
	}

}
