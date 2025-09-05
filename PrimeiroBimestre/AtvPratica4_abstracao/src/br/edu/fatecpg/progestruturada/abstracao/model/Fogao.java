package br.edu.fatecpg.progestruturada.abstracao.model;

public class Fogao {
	
	public int qtdBocas, tamanhoForno;
	public String modelo, marca, metFun, cor;
	boolean forno = false, fogao = false;

	public void LigarFogao() {
	if(!fogao) {
		System.out.println("Você ligou seu fogão!");
		fogao = true;
	}else {
		System.out.println("Seu fogão já está ligado!");
	}
}

	public void LigarForno() {
		if(!forno) {
			System.out.println("Você ligou seu Forno!");
			forno = true;
		}else {
			System.out.println("Seu Forno já está ligado!");
		}
	}
	
	public void Cozinhar() {
		if(forno || fogao) {
			System.out.println("Você está cozinhando!");
		}else {
			System.out.println("Seu forno/fogão está desligado!");
		}
	}
}
