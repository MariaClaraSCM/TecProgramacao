package br.edu.fatecpg.tecprog.atv6.view;
import br.edu.fatecpg.tecprog.atv6.model.Videolocadora;
import br.edu.fatecpg.tecprog.atv6.model.Biblioteca;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*System.out.println("PARTE DA LOCADORA:\n");
		 
		  Videolocadora novaLocadora = new Videolocadora(5);
		
		novaLocadora.setInformacoes(1, "Barbie", 10.50, 0);
		novaLocadora.setInformacoes(2, "Harry Potter", 20.60, 3);
		novaLocadora.setInformacoes(3, "The flash", 10, 6);
		novaLocadora.setInformacoes(4, "Vingadores", 30, 8);
		novaLocadora.setInformacoes(5, "Polly Pocket", 15.90, 15);
		
		novaLocadora.getInformarcoes();
		novaLocadora.valorTotalFilmes();
		System.out.println(novaLocadora.filmeMaisAlugado());
		novaLocadora.alugarProduto(2);
		novaLocadora.getInformarcoes();
		novaLocadora.retornarFilme(2);*/
		
		System.out.println("PARTE DA BIBLIOTECA:\n");
		
		Biblioteca novaBiblioteca = new Biblioteca(5);
		
		
		novaBiblioteca.setInformacoes(1, "Harry Potter", 0, 12.60);
		novaBiblioteca.setInformacoes(2, "Percy Jackson", 5, 12);
		novaBiblioteca.setInformacoes(3, "O Hobbit", 0, 60);
		novaBiblioteca.setInformacoes(4, "Os sete maridos de Evelyn Hugo", 3, 30);
		novaBiblioteca.setInformacoes(5, "Vermelho, branco e sangue azul", 9, 15);
		
		novaBiblioteca.getInformarcoes();
		novaBiblioteca.valorTotalMulta();
		novaBiblioteca.vlMedia();
		novaBiblioteca.pegarEmprestado(2);
		novaBiblioteca.pegarEmprestado(2);
		novaBiblioteca.getInformarcoes();
		novaBiblioteca.devolverLivro(2);
		novaBiblioteca.devolverLivro(2);
	}

}
