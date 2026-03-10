package br.edu.fatecpg.tecprog.atv6.model;

public class Videolocadora {
	private String[] filmes;
	private int[] vezesAlugado;
	private double[] precosLocacao;
	
	private int vlArray;
	
	public Videolocadora(int vlArray) {
		this.vlArray = vlArray;
		filmes = new String[vlArray];
		vezesAlugado = new int[vlArray];
		precosLocacao = new double[vlArray];
	}
	
	public void setInformacoes(int i, String nome, double preco, int alugado) {
		this.filmes[i-1] = nome;
		this.precosLocacao[i-1] = preco;
		this.vezesAlugado[i-1] = alugado;
	}
	
	public void getInformarcoes() {
		for(int c=0; c < this.vlArray; c++) {
			System.out.println(
					"Nome do filme: " + this.filmes[c] + "\n" +
					"Vezes que foi alugado: " + this.vezesAlugado[c] + "\n" +
					"Preço: " + this.precosLocacao[c] + "\n"
					);
		}
	}
	
	public void valorTotalFilmes() {
		double vlTotal = 0;
		for(int c = 0; c < this.vlArray; c++) {
			vlTotal += this.precosLocacao[c];
		}
		System.out.println("O valor total de todas os filmes alugadas de uma vez é: " + vlTotal + "\n");
	}
	
	public String filmeMaisAlugado(){
		int maisAlugado = 0;
		String filmeAlugado = "";
		for(int c = 0; c < this.vlArray; c++) {
			if(this.vezesAlugado[c]>maisAlugado) {
				maisAlugado = this.vezesAlugado[c];
				filmeAlugado = this.filmes[c];
			}
		}
		return "O filme mais alugado é " + filmeAlugado + ", e ele foi alugado "+ maisAlugado + " vezes.\n";
	}
	
	public void alugarProduto(int i) {
		this.vezesAlugado[i-1]++;
		System.out.println( "Você alugou o filme " + this.filmes[i-1] + " com sucesso!\n");
	}
	
	public void retornarFilme(int i) {
		System.out.println("Você devolveu o filme " + this.filmes[i-1] + " com sucesso!\n");
	}
}
