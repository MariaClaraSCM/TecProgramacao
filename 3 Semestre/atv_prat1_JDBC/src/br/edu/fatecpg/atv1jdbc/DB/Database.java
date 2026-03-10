package br.edu.fatecpg.atv1jdbc.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Database {
    public static Connection connection() throws SQLException {
        try {
            var jdbcUrl = "jdbc:postgresql://localhost:5432/db_gestao_tarefas";
            var user = "postgres";
            var password = "sua_senha";
            return DriverManager.getConnection(jdbcUrl, user, password);
        } catch(SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
