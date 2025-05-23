package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private String titulo;
    private int prioridade;
    private Date prazo;
    private boolean concluida = false;

    public Task(String titulo, int prioridade, Date prazo) {
        this.titulo = titulo;
        this.prioridade = prioridade;
        this.prazo = prazo;
    }

    public String getTitle() {
        return titulo;
    }

    public int getPriority() {
        return prioridade;
    }

    public Date getDeadline() {
        return prazo;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return "Tarefa: " + titulo + ", Prioridade: " + prioridade +
               ", Prazo: " + sdf.format(prazo) + ", Concluída: " + (concluida ? "Sim" : "Não");
    }
}