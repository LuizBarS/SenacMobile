package developer.android.santos.gerenciamentotarefas.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import developer.android.santos.gerenciamentotarefas.model.Tarefas;
import developer.android.santos.gerenciamentotarefas.view.MainActivity;

public class TarefasController {
    SharedPreferences preferences;
    SharedPreferences.Editor tarefasVip;
    public static final String NOME_PREFERENCES = "pref_tarefasvip";

    public TarefasController(MainActivity mainActivity){
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        tarefasVip = preferences.edit();
    }

    public void salvar(Tarefas tarefas){
        Log.d("MVC_Controller", "Salvo" + tarefas.toString());
        tarefasVip.putString("nomeTarefa", tarefas.getNomeTarefa());
        tarefasVip.putString("descTarefa", tarefas.getDescTarefa());
        tarefasVip.putString("dataConclusao", tarefas.getDataConclusao());
        tarefasVip.apply();
    }

    public Tarefas procurar(Tarefas tarefas){
        tarefas.setNomeTarefa(preferences.getString("nomeTarefa",""));
        tarefas.setDescTarefa(preferences.getString("descTarefa", ""));
        tarefas.setDataConclusao(preferences.getString("dataConclusao", ""));
        return tarefas;
    }

    public void limpar(){
        tarefasVip.clear();
        tarefasVip.apply();
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
