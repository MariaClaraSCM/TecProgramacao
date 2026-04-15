package br.edu.fatecpg.atv6;

public class Funcionario {
    private String nome;
    private String depto;
    private double salario;
    private int anosDeServico;

    public Funcionario(String nome, String depto, double salario, int anosDeServico) {
        this.nome = nome;
        this.depto = depto;
        this.salario = salario;
        this.anosDeServico = anosDeServico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAnosDeServico() {
        return anosDeServico;
    }

    public void setAnosDeServico(int anosDeServico) {
        this.anosDeServico = anosDeServico;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", depto='" + depto + '\'' +
                ", salario=" + salario +
                ", anosDeServico=" + anosDeServico +
                '}';
    }
}
