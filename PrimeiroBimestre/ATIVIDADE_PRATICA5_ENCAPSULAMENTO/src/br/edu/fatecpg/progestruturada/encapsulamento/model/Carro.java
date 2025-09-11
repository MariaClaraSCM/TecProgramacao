package br.edu.fatecpg.progestruturada.encapsulamento.model;

public class Carro {
	private String modelo, marca;
	private int ano;
	private float capacidadeTanque;
	
	 public String getMarca() {
		  return this.marca;
	}
	 
	 public String getModelo() {
		 return this.modelo;
	 }
	 
	 public int getAno() {
		 return this.ano;
	 }
	 
	 public float getTanque() {
		 return this.capacidadeTanque;
	 }
	 
	 public void setModelo(String novoModelo) {
		 this.modelo = novoModelo;
	 }
	 
	 public void setMarca(String novaMarca) {
		 this.marca = novaMarca;
	 }
	 
	 public void setAno(int novoAno) {
		 this.ano = novoAno;
	 }
	 
	 public void setCapTanque(float novaCapTanque) {
		 this.capacidadeTanque = novaCapTanque;
	 }
	 
	 public float calcularVlEncherTanque(float preco) {
		 return this.capacidadeTanque * preco;
	 }
}
