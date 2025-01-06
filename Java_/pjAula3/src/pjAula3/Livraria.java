package pjAula3;

public class Livraria {
	public static void main(String[] args) {
		// Instanciação de um objto do tipo obra
		Obra livro = new  Obra();
		livro.setCodigo(123);
		livro.setTitulo("Java como programar");
		
		Autor autor = new Autor();
		autor.setCodigo(365);
		autor.setNome("Deitel & Deitel");
		autor.setSitucao(true);
		livro.setAutor(autor);
		
		livro.setPreco(178.40f);
		livro.setSituacao(true);
		System.out.println(livro.toString());
		
		Obra outraObra = new Obra(789, "Banco de dados", autor,
				76.54f, false);
	}
}
