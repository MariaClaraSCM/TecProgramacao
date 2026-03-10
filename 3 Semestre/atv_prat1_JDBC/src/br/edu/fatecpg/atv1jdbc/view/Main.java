package br.edu.fatecpg.atv1jdbc.view;

import br.edu.fatecpg.atv1jdbc.DB.Database;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int opcaoEscolhida;

        try (Connection conn = Database.connection()) {

            System.out.println("Conexão estabelecida com sucesso!\n");

            do {

                System.out.print(menuTarefa());
                opcaoEscolhida = scan.nextInt();
                scan.nextLine();

                switch (opcaoEscolhida) {

                    case 1:
                        if (criarTarefa(conn)) {
                            System.out.println("Tarefa criada com sucesso!");
                        } else {
                            System.out.println("Não foi possível cadastrar a tarefa.");
                        }
                        break;

                    case 2:
                        System.out.println("\n-- Editar tarefa");
                        if (atualizarTarefa(conn)) {
                            System.out.println("Tarefa atualizada com sucesso!");
                        }
                        break;

                    case 3:
                        menuListagemTarefas(conn);
                        break;

                    case 4:
                        if (deletarTarefa(conn)) {
                            System.out.println("Tarefa deletada com sucesso.");
                        }
                        break;

                    case 5:
                        System.out.println("Tchau, tenha um ótimo dia ❤");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }

            } while (opcaoEscolhida != 5);

            scan.close();

        } catch (SQLException e) {

            System.out.println("Conexão não estabelecida!");
            System.err.println(e.getMessage());

        }
    }

    public static String menuTarefa() {

        return "\nEscolha uma das opções abaixo:"
                + "\n1. Nova tarefa"
                + "\n2. Editar tarefa"
                + "\n3. Listar tarefas"
                + "\n4. Deletar tarefa"
                + "\n5. Sair"
                + "\nSua escolha: ";
    }

    public static void menuListagemTarefas(Connection conn) {

        System.out.println(
                "\n-- Listar tarefas"
                        + "\n1. Todas"
                        + "\n2. Apenas concluídas"
                        + "\n3. Apenas não concluídas"
                        + "\n4. Apenas de uma categoria"
                        + "\n5. Voltar"
                        + "\nSua escolha: "
        );

        int opcaoListagem = scan.nextInt();
        scan.nextLine();

        switch (opcaoListagem) {

            case 1:
                listarTarefas(conn, null, null);
                break;

            case 2:
                listarTarefas(conn, "status", "true");
                break;

            case 3:
                listarTarefas(conn, "status", "false");
                break;

            case 4:
                System.out.print("Escolha a categoria: ");
                String categoria = scan.nextLine();
                listarTarefas(conn, "categoria", categoria);
                break;

            case 5:
                System.out.println("Voltando...");
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

    public static boolean formatarStatus(String status) {

        return switch (status.trim().toLowerCase()) {
            case "s", "sim", "y", "yes", "t", "true", "1", "concluido", "concluído" -> true;
            default -> false;
        };
    }

    // CRUD

    public static boolean criarTarefa(Connection conn) {

        String sql = "INSERT INTO tb_tarefa(nome, descricao, status, categoria) VALUES (?, ?, ?, ?)";

        System.out.println("\n-- Insira os dados da nova tarefa --");

        System.out.print("Nome: ");
        String nome = scan.nextLine();

        System.out.print("Descrição: ");
        String desc = scan.nextLine();

        System.out.print("Status: ");
        boolean status = formatarStatus(scan.nextLine());

        System.out.print("Categoria: ");
        String categoria = scan.nextLine();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, desc);
            stmt.setBoolean(3, status);
            stmt.setString(4, categoria);

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {

            System.err.println("Erro ao cadastrar tarefa: " + e.getMessage());
            return false;
        }
    }

    public static void listarTarefas(Connection conn, String filtro, String condicao) {

        String sql = "SELECT * FROM tb_tarefa";

        if (filtro != null && condicao != null) {
            sql += " WHERE " + filtro + " = ?";
        }

        sql += " ORDER BY id ASC";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (filtro != null && condicao != null) {
                stmt.setString(1, condicao);
            }

            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {

                System.out.println("Nenhuma tarefa encontrada.");

            } else {

                System.out.println("\nID | Nome | Descrição | Status | Categoria");

                do {

                    System.out.println(
                            rs.getInt("id") + " | "
                                    + rs.getString("nome") + " | "
                                    + rs.getString("descricao") + " | "
                                    + (rs.getBoolean("status") ? "Concluído" : "Não concluído") + " | "
                                    + rs.getString("categoria")
                    );

                } while (rs.next());
            }

        } catch (SQLException e) {

            System.out.println("Erro ao listar tarefas: " + e.getMessage());
        }
    }

    public static boolean atualizarTarefa(Connection conn) {

        String sql = "UPDATE tb_tarefa SET nome = ?, descricao = ?, status = ?, categoria = ? WHERE id = ?";

        System.out.print("Informe o ID da tarefa: ");
        int id = scan.nextInt();
        scan.nextLine();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            System.out.print("Nome: ");
            String nome = scan.nextLine();

            System.out.print("Descrição: ");
            String desc = scan.nextLine();

            System.out.print("Status: ");
            boolean status = formatarStatus(scan.nextLine());

            System.out.print("Categoria: ");
            String categoria = scan.nextLine();

            stmt.setString(1, nome);
            stmt.setString(2, desc);
            stmt.setBoolean(3, status);
            stmt.setString(4, categoria);
            stmt.setInt(5, id);

            int linhas = stmt.executeUpdate();

            return linhas > 0;

        } catch (SQLException e) {

            System.err.println("Erro ao atualizar tarefa: " + e.getMessage());
            return false;
        }
    }

    public static boolean deletarTarefa(Connection conn) {

        System.out.println(
                "\n-- Deletar tarefa"
                        + "\n1. Uma tarefa específica"
                        + "\n2. Todas as concluídas"
                        + "\n3. Voltar"
        );

        int opcao = scan.nextInt();
        scan.nextLine();

        try {

            switch (opcao) {

                case 1:

                    String sql = "DELETE FROM tb_tarefa WHERE id = ?";

                    System.out.print("Informe o ID da tarefa: ");
                    int id = scan.nextInt();
                    scan.nextLine();

                    try (PreparedStatement stmt = conn.prepareStatement(sql)) {

                        stmt.setInt(1, id);
                        stmt.executeUpdate();
                    }

                    break;

                case 2:

                    String sql2 = "DELETE FROM tb_tarefa WHERE status = ?";

                    try (PreparedStatement stmt = conn.prepareStatement(sql2)) {

                        stmt.setBoolean(1, true);
                        stmt.executeUpdate();
                    }

                    break;

                case 3:
                    return false;

                default:
                    System.out.println("Opção inválida.");
                    return false;
            }

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao deletar tarefa: " + e.getMessage());
            return false;
        }
    }
}