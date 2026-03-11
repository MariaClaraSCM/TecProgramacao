package br.edu.fatecpg.atvd3.dao;

import br.edu.fatecpg.atvd3.db.Database;
import br.edu.fatecpg.atvd3.model.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmpresaDAO {

    public void salvar(Empresa empresa) {

        String sql = "INSERT INTO tb_empresa (cnpj, razao_social, nome_fantasia, logradouro) VALUES (?, ?, ?, ?)";

        try (
                Connection conn = Database.connection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {

            stmt.setString(1, empresa.getCnpj());
            stmt.setString(2, empresa.getRazao_social());
            stmt.setString(3, empresa.getNome_fantasia());
            stmt.setString(4, empresa.getLogradouro());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao salvar empresa: " + e.getMessage());
        }
    }
}