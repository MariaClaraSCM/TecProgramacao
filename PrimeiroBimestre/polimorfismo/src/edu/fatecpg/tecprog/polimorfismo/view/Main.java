package edu.fatecpg.tecprog.polimorfismo.view;

import edu.fatecpg.tecprog.polimorfismo.model.*;

public class Main {
    public static void main(String[] args) {
        Veiculo v1 = new Carro();
        Veiculo v2 = new Bicicleta();

        v1.mover();
        v2.mover();
        
        Calculadora calc = new Calculadora();
        
        System.out.println("Somar 2 numeros inteiros: " + calc.somar(5,5));
        System.out.println("Somar 3 numeros inteiros: " + calc.somar(5,5,5));
        System.out.println("Somar 2 numeros decimais: " + calc.somar(2.5,2.5));
        
        Produto p1 = new Produto("Caneta");
        Produto p2 = new Produto("Caderno", 12.50);
        Produto p3 = new Produto("Mochila", 150.00, 10);

        p1.mostrarInfo();
        p2.mostrarInfo();
        p3.mostrarInfo();
        
        Pagamento pagGen = new Pagamento();
        Pagamento pagCart = new PagamentoCartao();
        Pagamento pagBol = new PagamentoBoleto();

        pagGen.processarPagamento(); 
        pagCart.processarPagamento();   
        pagBol.processarPagamento(); 
        
        Conversor conv = new Conversor();

        double fahrenheit = conv.converter(25.0);
        System.out.println("25°C em Fahrenheit: " + fahrenheit);

        double milhas = conv.converter(10);
        System.out.println("10 km em milhas: " + milhas);

        String maiusculas = conv.converter("olá mundo");
        System.out.println("Texto em maiúsculas: " + maiusculas);
    }
}
