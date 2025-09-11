package br.edu.fatecpg.progestruturada.encapsulamento.model;

public class Produto {
	/*Implemente uma classe Produto com os atributos privados nome, preco e quantidadeEstoque. Crie métodos getters e setters para esses
	atributos. Adicione uma regra no setter de preco que impede a definição de valores negativos. No setter de quantidadeEstoque, o valor
	deve ser ajustado apenas se for maior ou igual a zero. No método main, crie um objeto Produto e teste as restrições definidas.*/
	
	private String nome;
	private double preco;
	private int qtdEstoque;
	
	public Produto(String nome, double preco, int qtde) {
		this.nome = nome;
		this.preco = preco;
		this.qtdEstoque = qtde;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getQtde() {
		return this.qtdEstoque;
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public void setQtde(int novoQtde) {
		if(novoQtde > 0) {
			this.qtdEstoque = novoQtde;
			System.out.println("O estoque do produto " + this.nome + " foi atualizado para " + this.qtdEstoque + "\n");
		}else {
			System.out.println("Não é possivel alterar o estoque para um núemro negativo! \n");
		}
	}
	
	public void setPreco(double novoPreco) {
		if(novoPreco > 0) {
			this.preco = novoPreco;
			System.out.println("O preço do produto " + this.nome + " foi atualizado para " + this.preco + "\n");
		}else {
			System.out.println("Não é possivel alterar o preço para um núemro negativo! \n");	
		}
		
	}
}
