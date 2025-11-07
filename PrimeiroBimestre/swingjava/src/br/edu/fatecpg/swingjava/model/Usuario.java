package br.edu.fatecpg.swingjava.model;

public class Usuario {
    private String tema;
    private boolean notificacoes;
    private int volume;

    public Usuario(String tema, boolean notificacoes, int volume) {
        this.tema = tema;
        this.notificacoes = notificacoes;
        this.volume = volume;
    }

    public String getResumo() {
        return "Tema: " + tema +
               "\nNotificações: " + (notificacoes ? "Ativadas" : "Desativadas") +
               "\nVolume: " + volume + "%";
    }

    // Getters para persistência
    public String getTema() { return tema; }
    public boolean getNotificacoes() { return notificacoes; }
    public int getVolume() { return volume; }
}
