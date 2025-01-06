package adc4;

import java.util.InputMismatchException;;
import java.util.Scanner;

public class DivisaoZero {
	public static int divide(int numerador, int denominador) {
		return numerador / denominador;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
		System.out.print("Por favor informe o inteiro numerador: ");
		int numerador = scanner.nextInt();
		System.out.print("Por favor digite o inteiro denominador: ");
		int denominador = scanner.nextInt();
		int resultado = divide(numerador, denominador);
		System.out.print("\nResultado: %d / %d = %d\n", numerador, denominador, resultado);
		} catch(Exception e) {
			
		}
		
		
	}
}
