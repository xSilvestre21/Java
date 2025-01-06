package pjAula2;

public class Teste {
	public static void main(String[] args) {
		Automovel carro = new Automovel();
			carro.ano = 1990;
			carro.cor = "Colorido";
			System.out.println(carro.ano);
			
			for(int i = 51; i <= 171; i++) {
				System.out.println(i);
			}
			
			Cliente voce = new Cliente();
			voce.setNome("Gustavo");
			System.out.println(voce.getNome());
	}
	
} 