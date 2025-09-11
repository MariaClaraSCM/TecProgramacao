package br.edu.fatecpg.progestruturada.encapsulamento.view;
import br.edu.fatecpg.progestruturada.encapsulamento.model.Carro;
import br.edu.fatecpg.progestruturada.encapsulamento.model.ContaBancaria;
import br.edu.fatecpg.progestruturada.encapsulamento.model.Produto;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ler = new Scanner(System.in);
		
		/*PARTE CARRO*/
		System.out.println("CARRO: \n");
		
		Carro carro = new Carro();
		
		System.out.println("Digite a marca do carro: ");
		carro.setMarca(ler.nextLine());
		
		System.out.println("Digite o modelo do carro: ");
		carro.setModelo(ler.nextLine());
		
		System.out.println("Digite o ano do carro: ");
		carro.setAno(ler.nextInt());
		
		System.out.println("Digite a capacidade maxima de gasolina do tanque do carro: ");
		carro.setCapTanque(ler.nextFloat());
		
		System.out.println("Digite o valor por litro da gasolina: ");
		float preco = ler.nextFloat();
		
		DecimalFormat df = new DecimalFormat("#.00");
		
		System.out.println("O seu carro é um " + carro.getMarca() + " " + carro.getModelo() + ", ano " + carro.getAno() + ".");
		System.out.println("O seu carro tem capacidade de " + carro.getTanque() + "L, então o valor para encher o tanque de gasolina fica: R$" + df.format(carro.calcularVlEncherTanque(preco)) + "\n");
		
		/*PARTE CONTA BANCARIA*/
		
		System.out.println("CONTA BANCARIA: \n");
		
		ContaBancaria conta = new ContaBancaria("Usuario", 10);
		
		System.out.println("Olá " + conta.getTitular() + ". Seu saldo atual é: " + conta.getSaldo());
		
		System.out.println("O que você gostária de fazer?");
		System.out.println("┌───────────────┐");
		System.out.println("│ 1 - Sacar     │");
		System.out.println("│ 2 - Depositar │");
		System.out.println("└───────────────┘");
		int e = ler.nextInt();
		
		switch(e) {
		case 1:
			System.out.println("Quanto você quer sacar?");
			conta.setSacar(ler.nextFloat());
			break;
		case 2:
			System.out.println("Quanto você quer depositar?");
			conta.setDepositar(ler.nextFloat());
			break;
		default:
			System.out.println("Escolha uma opção válida!");
			break;
		}
		
		System.out.println("Seu saldo atual é: " + df.format(conta.getSaldo()));
		
		/*PARTE PRODUTO*/
		
		System.out.println("PRODUTO: \n");
		
		Produto produto = new Produto("Pasta de dente", 3.50, 100);
		
		System.out.println("nome: " + produto.getNome());
		System.out.println("preço: " + produto.getPreco());
		System.out.println("Qtde em estoque: " + produto.getQtde() + "\n");
		
		System.out.println("O que você gostária de alterar?");
		System.out.println("┌─────────────────────┐");
		System.out.println("│ 1 - Alterar preço   │");
		System.out.println("│ 2 - Alterar estoque │");
		System.out.println("└─────────────────────┘");
		int e2 = ler.nextInt();
		
		switch(e2) {
		case 1:
			System.out.println("Digete o novo preço:");
			produto.setPreco(ler.nextDouble());
			break;
		case 2:
			System.out.println("Atualize o estoque:");
			produto.setQtde(ler.nextInt());
			break;
		default:
			System.out.println("Escolha uma opção válida!");
			break;
		}
		
		System.out.println("nome: " + produto.getNome());
		System.out.println("preço: " + produto.getPreco());
		System.out.println("Qtde em estoque: " + produto.getQtde());
		
		ler.close();
	}

}
