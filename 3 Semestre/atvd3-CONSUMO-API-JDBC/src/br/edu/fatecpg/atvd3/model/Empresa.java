package br.edu.fatecpg.atvd3.model;

import java.util.List;

public class Empresa {

    private String cnpj;
    private String razao_social;
    private String nome_fantasia;
    private String logradouro;

    // lista de sócios que vem da API no campo "qsa"
    private List<Socio> qsa;

    // construtor vazio (necessário para o Gson)
    public Empresa() {
    }

    public Empresa(String cnpj, String razao_social, String nome_fantasia, String logradouro) {
        this.cnpj = cnpj;
        this.razao_social = razao_social;
        this.nome_fantasia = nome_fantasia;
        this.logradouro = logradouro;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public List<Socio> getQsa() {
        return qsa;
    }

    public void setQsa(List<Socio> qsa) {
        this.qsa = qsa;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "cnpj='" + cnpj + '\'' +
                ", razao_social='" + razao_social + '\'' +
                ", nome_fantasia='" + nome_fantasia + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", qsa=" + qsa +
                '}';
    }
}