package br.edu.fatecpg.atv2api.view;

import java.util.Scanner;
import java.util.ArrayList;

import br.edu.fatecpg.atv2api.model.Endereco;
import br.edu.fatecpg.atv2api.service.ConsomeApi;
import com.google.gson.Gson;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scan = new Scanner(System.in);
        Gson gson = new Gson();

        ArrayList<Endereco> enderecos = new ArrayList<>();

        int opcaoEscolhida = 0;

        while (opcaoEscolhida != 4) {

            System.out.println("\nDigite sua escolha abaixo:"
                    + "\n1. Buscar endereço"
                    + "\n2. Excluir endereço da lista"
                    + "\n3. Histórico de endereços buscados"
                    + "\n4. Sair do programa"
                    + "\nSua escolha: ");

            opcaoEscolhida = scan.nextInt();

            switch (opcaoEscolhida) {

                case 1:

                    System.out.println("Digite o CEP a ser buscado:");
                    String cep = scan.next();

                    boolean jaExiste = false;

                    for (Endereco e : enderecos) {
                        if (e.getCep().equals(cep)) {
                            System.out.println("Endereço já está na lista:");
                            System.out.println(e);
                            jaExiste = true;
                            break;
                        }
                    }

                    if (!jaExiste) {

                        String retorno = ConsomeApi.buscaCEP(Integer.parseInt(cep));

                        Endereco end = gson.fromJson(retorno, Endereco.class);

                        enderecos.add(end);

                        System.out.println("Endereço adicionado:");
                        System.out.println(end);
                    }

                    break;

                case 2:

                    if (enderecos.isEmpty()) {
                        System.out.println("Nenhum endereço na lista.");
                        break;
                    }

                    System.out.println("Digite o CEP que deseja excluir:");
                    String cepExcluir = scan.next();

                    boolean removido = false;

                    for (Endereco e : enderecos) {

                        if (e.getCep().equals(cepExcluir)) {
                            enderecos.remove(e);
                            removido = true;
                            System.out.println("Endereço removido.");
                            break;
                        }
                    }

                    if (!removido) {
                        System.out.println("CEP não encontrado na lista.");
                    }

                    break;

                case 3:

                    if (enderecos.isEmpty()) {
                        System.out.println("Nenhum endereço pesquisado.");
                    } else {

                        System.out.println("\nHistórico de endereços:");

                        for (Endereco e : enderecos) {
                            System.out.println(e);
                        }
                    }

                    break;

                case 4:
                    System.out.println("Encerrando programa...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scan.close();
    }
}
