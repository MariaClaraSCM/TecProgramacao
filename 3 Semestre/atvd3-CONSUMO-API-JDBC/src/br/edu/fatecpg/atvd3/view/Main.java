package br.edu.fatecpg.atvd3.view;

import br.edu.fatecpg.atvd3.dao.EmpresaDAO;
import br.edu.fatecpg.atvd3.dao.SocioDAO;
import br.edu.fatecpg.atvd3.model.Empresa;
import br.edu.fatecpg.atvd3.model.Socio;
import br.edu.fatecpg.atvd3.service.ConsumoApiCnpj;
import com.google.gson.Gson;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        try {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite o CNPJ:");
            String cnpj = scanner.nextLine();

            // remover pontuação
            cnpj = cnpj.replaceAll("[^0-9]", "");

            ConsumoApiCnpj api = new ConsumoApiCnpj();

            String json = api.buscarEmpresa(cnpj);

            Gson gson = new Gson();

            Empresa empresa = gson.fromJson(json, Empresa.class);

            EmpresaDAO empresaDAO = new EmpresaDAO();
            empresaDAO.salvar(empresa);

            SocioDAO socioDAO = new SocioDAO();

            if (empresa.getQsa() != null) {
                for (Socio socio : empresa.getQsa()) {
                    socioDAO.salvar(socio, empresa.getCnpj());
                }
            }

            System.out.println("Empresa e sócios salvos com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro na aplicação: " + e.getMessage());
        }
    }
}