package pjAula4;

public class TesteOperacao {
	public void calcular(OperacaoMatematica op, double a,
			double b) {
		System.out.println(op.calcular(a, b));
		op.getTipo();
	}
	
	public static void main(String[] args) {
		TesteOperacao teste = new TesteOperacao();
		
		teste.calcular(new Soma(), 123, 456);
		teste.calcular(new Subtracao(), 123, 456);
		teste.calcular(new Multiplicacao(), 4, 5);
		teste.calcular(new Modulo(), 10, 3);
		
		Divisao div = new Divisao();
		teste.calcular(div, 6, 3);
		
		OperacaoMatematica multi = new Multiplicacao();
		teste.calcular(multi, 6, 3);
	}

}
