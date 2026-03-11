package br.edu.fatecpg.atvd3.dao;

import br.edu.fatecpg.atvd3.db.Database;
import br.edu.fatecpg.atvd3.model.Socio;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SocioDAO {

    public void salvar(Socio socio, String cnpjEmpresa) {

        String sql = "INSERT INTO tb_socio (nome_socio, cnpj_cpf_do_socio, qualificacao_socio, cnpj_empresa) VALUES (?, ?, ?, ?)";

        try (
                Connection conn = Database.connection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {

            stmt.setString(1, socio.getNome_socio());
            stmt.setString(2, socio.getCnpj_cpf_do_socio());
            stmt.setString(3, socio.getQualificacao_socio());
            stmt.setString(4, cnpjEmpresa);

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao salvar socio: " + e.getMessage());
        }
    }
}
