package br.edu.fatecpg.progestruturada.abstracao.model;

public class Bicicleta {
	
	public int tamguidao, tamRodas;
	public String cor, modelo, tipocorrente, modBanco; 
	boolean sentar = false, pedalar = false;
	
	public void Sentar() {
		if(!sentar) {
			System.out.println("Você sentou na bicicleta");
			sentar = true;
		}else {
			System.out.println("Você já está sentado");
		}
	}
	
	public void Pedalar() {
		if(sentar) {
			System.out.println("Você está pedalando");
			pedalar = true;
		}else {
			System.out.println("Você nem tá sentado, vai pedalar como?");
		}
	}
	
	public void Frear() {
		if(pedalar) {
			System.out.println("Você freiou a bicicleta");
			pedalar = false;
		}else {
			System.out.println("Você precisa estar pedalando para frear");
		}
	}
}
