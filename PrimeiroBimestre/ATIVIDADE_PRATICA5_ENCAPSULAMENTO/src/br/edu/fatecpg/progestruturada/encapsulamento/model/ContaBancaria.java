package br.edu.fatecpg.progestruturada.encapsulamento.model;

public class ContaBancaria {
	
	private String titular;
	private double saldo;
	
	public ContaBancaria(String titular,double saldo) {
		this.titular = titular;
		this.saldo = saldo;
	}
	
	public String getTitular() {
		return this.titular;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	
	public void setDepositar(float novoDepositar) {
	    if(novoDepositar > 0) {
	        this.saldo += novoDepositar;
	        System.out.println("Você depositou com sucesso!");
	    } else {
	        System.out.println("Não é possivel depositar numeros negativos!");
	    }
	}
	
	public void setSacar(float novoSacar) {
	    if(novoSacar > 0 && novoSacar <= this.saldo) {
	        this.saldo -= novoSacar;
	        System.out.println("Seu saque foi realizado com sucesso!");
	    } else {
	        System.out.println("Não é possivel fazer um saque com esse valor!");
	    }
	}
	
	
}
