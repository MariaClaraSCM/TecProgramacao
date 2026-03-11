package br.edu.fatecpg.atvd3.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    public static Connection connection() {

        try {

            String url = "jdbc:postgresql://localhost:5432/db_consulta_cnpj";
            String user = "postgres";
            String password = "2110";

            return DriverManager.getConnection(url, user, password);

        } catch (Exception e) {

            System.out.println("Erro na conexão: " + e.getMessage());
            return null;

        }
    }
}