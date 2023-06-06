package dev.android.santos.gerenciamentotarefas.model;

public class Tarefas {
    private String nomeTarefa;
    private String descTarefa;
    private String dataConclusao;

    public Tarefas() {
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getDescTarefa() {
        return descTarefa;
    }

    public void setDescTarefa(String descTarefa) {
        this.descTarefa = descTarefa;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    @Override
    public String toString() {
        return "Tarefas{" +
                "nomeTarefa='" + nomeTarefa + '\'' +
                ", descTarefa='" + descTarefa + '\'' +
                ", dataConclusao='" + dataConclusao + '\'' +
                '}';
    }
}
