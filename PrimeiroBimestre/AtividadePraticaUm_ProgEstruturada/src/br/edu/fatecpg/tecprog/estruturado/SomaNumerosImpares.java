package br.edu.fatecpg.tecprog.estruturado;

import java.util.Scanner;

public class SomaNumerosImpares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ler = new Scanner(System.in);
		System.out.println("Digite a quantidade de números ímpares que deseja somar: ");
		int num = ler.nextInt();

		int resultado = 0;

		for (int i = 0; i < num; i++) {
		    int impar = 2 * i + 1;  // gera o número ímpar atual, confesso que não entendi muito bem, revisar
		    resultado += impar;    
		}

		System.out.printf("A soma dos primeiros %d números ímpares é %d%n", num, resultado);
		
		ler.close();
	}

}
