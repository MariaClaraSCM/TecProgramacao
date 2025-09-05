package br.edu.fatecpg.progestruturada.abstracao.model;

public class Geladeira {
/*Geladeira

● TamanhoInterno;

● CapacidadeFreezer;

● QtdGavetas;

● Modelo;

● Motor;

➔ AbrirGeladeira()

➔ AbrirFreezer()

➔ PegarItem()*/
	public String marca, modelo, cor;
	public int tamInterno, qtdGavetas, motor;
	boolean abrir = false, pegar = false;
	
	public void AbrirGeladeira() {
		if(!abrir) {
			System.out.println("VocÊ abriu a geladeira");
			abrir = true;
		}else {
			System.out.println("Sua geladeira já está aberta");
		}
	}
	
	public void FecharGeladeira() {
		if(abrir) {
			System.out.println("Você fechou sua geladeira");
			abrir = false;
		}else {
			System.out.println("Sua geladeira já está fechada");
		}
	}
	
	public void PegarItem() {
		if(abrir) {
			if(!pegar) {
				System.out.println("Você pegou um item");
				pegar = true;
			}else {
				System.out.println("Você já pegou um item!");
			}
		}else {
			System.out.println("A geladeira está fechada!");
		}
	}

}
