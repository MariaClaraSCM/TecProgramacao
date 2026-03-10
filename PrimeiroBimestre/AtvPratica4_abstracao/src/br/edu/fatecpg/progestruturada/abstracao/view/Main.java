package br.edu.fatecpg.progestruturada.abstracao.view;
import java.text.DecimalFormat;
import br.edu.fatecpg.progestruturada.abstracao.model.Fogao;
import br.edu.fatecpg.progestruturada.abstracao.model.Carro;
import br.edu.fatecpg.progestruturada.abstracao.model.Geladeira;
import br.edu.fatecpg.progestruturada.abstracao.model.Ventilador;
import br.edu.fatecpg.progestruturada.abstracao.model.Bicicleta;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("ABSTRAÇÃO CARRO:\n");
		Carro meuCarro = new Carro();
		
		meuCarro.marca = "Chevrolet";
		meuCarro.modelo = "Prisma";
		meuCarro.ano = 2006;
		meuCarro.cor = "rosa";
		meuCarro.capTanque = 54;
		
		Carro meuCarro2 = new Carro();
		
		meuCarro2.marca = "Aston Martin";
		meuCarro2.modelo = "Valhalla";
		meuCarro2.ano = 2025;
		meuCarro2.cor = "Azul";
		meuCarro2.capTanque = 50;
		
		System.out.println("Informações do 1° carro:");
		System.out.println("Meu carro é um " + meuCarro.marca + " " + meuCarro.modelo +  " ano "+ meuCarro.ano + " da cor " + meuCarro.cor + " e seu tanque tem a capacidade de " + meuCarro.capTanque + " litros.\n");
		System.out.println("Informações do 2° carro:");
		System.out.println("Meu carro é um " + meuCarro2.marca + " " + meuCarro2.modelo +  " ano "+ meuCarro2.ano + " da cor " + meuCarro2.cor + " e seu tanque tem a capacidade de " + meuCarro2.capTanque + " litros.\n");
		
		System.out.println("---------------------------------------- \n");
		
		System.out.println("Métodos:");
		meuCarro.ligar();		//liga o carro
		meuCarro.ligar();		//para confirmar a mensagem de verificação
		meuCarro.Acelerar(); 	//acelera
		meuCarro.Buzinar();
		meuCarro.Desligar(); 	//desliga
		meuCarro.Acelerar();	//para confirmar a mensagem de verificação da aceleração
		meuCarro.Desligar();	//para confirmar a mensagem de verificação
		
		System.out.println("---------------------------------------- \n");
		
		System.out.println("ABSTRAÇÃO FOGÃO \n");
		Fogao fogao = new Fogao();

		fogao.cor = "Cinza";
		fogao.marca = "Brastemp";
		fogao.metFun = "Indução";
		fogao.modelo = "Cooktop";
		fogao.qtdBocas = 5;
		fogao.tamanhoForno = 45;
		
		Fogao fogao2 = new Fogao();

		fogao2.cor = "Rosa";
		fogao2.marca = "Brastemp";
		fogao2.metFun = "Gás";
		fogao2.modelo = "Tradicional";
		fogao2.qtdBocas = 4;
		fogao2.tamanhoForno = 35;
		
		System.out.println("Informações do 1° fogão:");
		System.out.println("Meu fogão é um " + fogao.marca + " " + fogao.modelo +  " por " + fogao.metFun + ", tem " + fogao.qtdBocas + " bocas, o tamanha do forno é de " + fogao.tamanhoForno + " litros e é da cor " + fogao.cor + "\n");
		System.out.println("Informações do 2° fogão:");
		System.out.println("Meu fogão é um " + fogao2.marca + " " + fogao2.modelo +  " a " + fogao2.metFun + ", tem " + fogao2.qtdBocas + " bocas, o tamanha do forno é de " + fogao2.tamanhoForno + " litros e é da cor " + fogao2.cor + "\n");
		
		fogao.Cozinhar(); //verificação para cozinhar
		fogao.LigarFogao(); //liga o fogao
		fogao.LigarFogao();	//verificaçao do fogao
		fogao.LigarForno(); //liga o forno
		fogao.LigarForno(); //verificação do forno
		fogao.Cozinhar(); //cozinha
		
		System.out.println("---------------------------------------- \n");
		
		System.out.println("ABSTRAÇÃO GELADEIRA \n");
		Geladeira geladeira = new Geladeira();
		
		
		geladeira.marca = "Brastemp";
		geladeira.modelo = "Forst free duas portas";
		geladeira.cor = "Cinza";
		geladeira.motor = 3000;
		geladeira.qtdGavetas = 3;
		geladeira.tamInterno = 175;
		
		DecimalFormat df = new DecimalFormat("#,###");
		String motor = df.format(geladeira.motor);
		DecimalFormat df2 = new DecimalFormat("#,##");
		String tamInt = df2.format(geladeira.tamInterno);
		
		Geladeira geladeira2 = new Geladeira();
		
		geladeira2.marca = "Consul";
		geladeira2.modelo = "Compactor um porta";
		geladeira2.cor = "Branco";
		geladeira2.motor = 6000;
		geladeira2.qtdGavetas = 1;
		geladeira2.tamInterno = 145;
		
		String motor2 = df.format(geladeira2.motor);
		String tamInt2 = df2.format(geladeira2.tamInterno);
		
		System.out.println("Informações da 1° geladeira:");
		System.out.println("Minha geladeira é uma " + geladeira.marca +  " " + geladeira.modelo + " da cor " + geladeira.cor + " com o motor de " + motor + " BTU/h" + " tamanho interno de " + tamInt + "cm e com " + geladeira.qtdGavetas + " gavetas.\n");
		System.out.println("Informações da 2° geladeira:");
		System.out.println("Minha geladeira é uma " + geladeira2.marca + " " + geladeira2.modelo + " da cor " + geladeira2.cor + " com o motor de " + motor2 + " BTU/h" + " tamanho interno de " + tamInt2 + "cm e com " + geladeira2.qtdGavetas + " gavetas.\n");
		
		geladeira.PegarItem();
		geladeira.FecharGeladeira();
		geladeira.AbrirGeladeira();
		geladeira.AbrirGeladeira();
		geladeira.PegarItem();
		geladeira.FecharGeladeira();
		
		System.out.println("---------------------------------------- \n");
		
		System.out.println("ABSTRAÇÃO VENTILADOR \n");
		Ventilador ventilador = new Ventilador();
		
		ventilador.marca = "Monldial";
		ventilador.modelo = "turbo VT40NB";
		ventilador.motor = 150;
		ventilador.qtdHelice = 8;
		ventilador.tamBase = 40;	 
		
		Ventilador ventilador2 = new Ventilador();
		
		ventilador2.marca = "Britânia";
		ventilador2.modelo = "Maxx Force BVT400";
		ventilador2.motor = 150;
		ventilador2.qtdHelice = 6;
		ventilador2.tamBase = 40;
		
		System.out.println("informações do 1° ventilador: ");
		System.out.println("meu ventilador é um " + ventilador.modelo + " da " + ventilador.marca + " com o motor de " + ventilador.motor + "w a base de " + ventilador.tamBase + "cm e " + ventilador.qtdHelice + " pás.\n");
		System.out.println("informações do 2° ventilador: ");
		System.out.println("meu ventilador é um " + ventilador2.modelo + " da " + ventilador2.marca + " com o motor de " + ventilador2.motor + "w a base de " + ventilador2.tamBase + "cm e " + ventilador2.qtdHelice + " pás.\n");
		
		ventilador.Rodar();
		ventilador.Desligar();
		ventilador.Ligar();
		ventilador.Rodar();
		ventilador.Velocidade();
		ventilador.Desligar();
		
		System.out.println("---------------------------------------- \n");
		
		System.out.println("ABSTRAÇÃO BICICLETA \n");
		Bicicleta bicicleta = new Bicicleta();
		
		bicicleta.cor = "rosa";
		bicicleta.modelo = "Urbana";
		bicicleta.tamRodas = 305;
		bicicleta.tipocorrente = "dupla ";
		bicicleta.modBanco = "Selim Selle Royal Premium Rvs Gel";
		bicicleta.tamguidao = 750;
		
		Bicicleta bicicleta2 = new Bicicleta();
		
		bicicleta2.cor = "roxo";
		bicicleta2.modelo = "Fixa";
		bicicleta2.tamRodas = 584;
		bicicleta2.tipocorrente = "simples";
		bicicleta2.modBanco = "Caloi Xr";
		bicicleta2.tamguidao = 800;
		
		System.out.println("informações da 1° bicicleta: ");
		System.out.println("Minha bicicleta é uma " + bicicleta.modelo + " da cor " + bicicleta.cor + ", o tamanho da roda é  " + bicicleta.tamRodas + "mm, modelo do banco " + bicicleta.modBanco + ", tamanho do guidão " + bicicleta.tamguidao + "mm e a corrente é do modelo " + bicicleta.tipocorrente + "\n");
		System.out.println("informações da 2° bicicleta: ");
		System.out.println("Minha bicicleta é uma " + bicicleta2.modelo + " da cor " + bicicleta2.cor + " com o modelo de rodas " + bicicleta2.tamRodas + "mm, tamanho do banco " + bicicleta2.modBanco + ", tamanho do guidão " + bicicleta2.tamguidao + "mm e a corrente é do modelo " + bicicleta2.tipocorrente + "\n");
		
		bicicleta.Frear();
		bicicleta.Pedalar();
		bicicleta.Sentar();
		bicicleta.Pedalar();
		bicicleta.Frear();
		}

}
