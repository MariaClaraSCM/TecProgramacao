package br.edu.fatecpg.progestruturada.abstracao.model;
import java.util.Scanner;

public class Ventilador {
/*Ventilador

● TamanhoBase;

● BotaoVelocidade;

● Modelo;

● QtdHélices;

● MotorEletrico;

➔ Ligar();

➔ AtivarRotacao();

➔ AlterarVelocidade();*/
	public int tamBase,qtdHelice, motor;
	public String modelo, marca;
	boolean ligar = false;
	
	public void Ligar() {
		if(!ligar) {
			System.out.println("Você ligou o ventilador");
			ligar = true;
		}else {
			System.out.println("O ventilador já está ligado");
		}
	}
	
	public void Rodar() {
		if(ligar) {
			System.out.println("O ventilador está rodando");
		}else {
			System.out.println("O ventilador está desligado, ligue ele primeiro");
		}
	}
	
	public void Desligar() {
		if(ligar) {
			System.out.println("Você desligou o ventilador");
			ligar = false;
		}else {
			System.out.println("Já está desligado");
		}
	}
	
	public void Velocidade() {
		if(ligar) {
			Scanner ler = new Scanner(System.in);
			
			System.out.println("Digite 1, 2 ou 3 para mudar a velocidade (Digita ai para continuar pfv)");
			int v = ler.nextInt();
			
			switch(v) {
			case 1:
				System.out.println("Você está na velocidade um");
				break;
			case 2:
				System.out.println("Você está na velocidade dois");
				break;
			case 3:
				System.out.println("Você está na velocidade três");
				break;
			default:
				System.out.println("Digite um velocidade valida!");
			}
			
			ler.close();
			
		}else {
			System.out.println("Está desligado!");
		}
		
	}
}
