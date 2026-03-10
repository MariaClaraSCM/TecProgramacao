package br.edu.fatecpg.atv1jdbc.model;

public class Tarefa {
    private int id;
    private String nome;
    private String descricao;
    private boolean status;
    private String categoria;

    public Tarefa(int id, String nome, String descricao, boolean status, String categoria) {
        super();
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Tarefa [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", status=" + status
                + ", categoria=" + categoria + "]";
    }
}
