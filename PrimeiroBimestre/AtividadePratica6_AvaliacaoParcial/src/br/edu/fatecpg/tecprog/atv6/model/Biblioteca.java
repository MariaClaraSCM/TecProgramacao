package br.edu.fatecpg.tecprog.atv6.model;
import java.text.DecimalFormat;

public class Biblioteca {
	private String[] livros;
    private String[] emprestimos; 
	private int[] diasAtraso;
	private double[] multaPorDia;
	
	private int vlArray;
	
	public Biblioteca(int vlArray) {
		this.vlArray = vlArray;
		livros = new String[vlArray];
		emprestimos = new String[vlArray];
		diasAtraso = new int[vlArray];
		multaPorDia = new double[vlArray];
	}
	
	public void setInformacoes(int i, String nmLivros, int diasAtraso, double multaPorDia) {
		this.livros[i-1] = nmLivros;
		this.diasAtraso[i-1] = diasAtraso;
		this.multaPorDia[i-1] = multaPorDia;	
	}
	
	public void getInformarcoes() {
		for(int c=0; c < this.vlArray; c++) {
			System.out.println(
					"Nome do livro: " + this.livros[c] + "\n" +
					"Dias em atraso: " + this.diasAtraso[c] + "\n" +
					"Valor da multa por dia: " + this.multaPorDia[c] + "\n"
					);
		}
	}
	
	public void valorTotalMulta() {
		double vlTotal = 0;
		for(int c = 0; c < vlArray; c++) {
			if(this.diasAtraso[c] != 0) {
				vlTotal = this.multaPorDia[c] * this.diasAtraso[c];
				System.out.println("O valor total de atraso do livro " + this.livros[c] + " é: " + vlTotal + "\n");
			}
		}
	}
	
	DecimalFormat df = new DecimalFormat("0.00");
	
	public void vlMedia() {
		double dias = 0;
		int contador = 0;
		for(int c = 0; c < vlArray; c++) {
			if(this.diasAtraso[c] != 0) {
				dias += this.diasAtraso[c];
				contador++;
			}
		}
		
		System.out.println("A média de dias de atraso dos livros devolvidos com atraso é: " + df.format(dias/contador) +".\n");
	}
	
    public void pegarEmprestado(int i) {
        int idx = i - 1;

        if (idx >= 0 && idx < vlArray) {
            if (livros[idx] != null) {
                System.out.println("Livro emprestado: " + livros[idx] + "\n");
                emprestimos[idx] = livros[idx]; 
                livros[idx] = null;
            } else {
                System.out.println("Esse livro já foi emprestado.\n");
            }
        } else {
            System.out.println("Índice fora do intervalo.\n");
        }
    }

    public void devolverLivro(int i) {
        int idx = i - 1;

        if (idx >= 0 && idx < vlArray) {
            if (emprestimos[idx] != null) {
                livros[idx] = emprestimos[idx]; 
                emprestimos[idx] = null;
                System.out.println("Livro devolvido: " + livros[idx] + "\n");
            } else {
                System.out.println("Não há livro emprestado nesse índice.\n");
            }
        } else {
            System.out.println("Índice fora do intervalo.\n");
        }
    }
}

