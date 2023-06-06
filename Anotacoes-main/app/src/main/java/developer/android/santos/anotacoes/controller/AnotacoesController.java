package developer.android.santos.anotacoes.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import developer.android.santos.anotacoes.model.Anotacoes;
import developer.android.santos.anotacoes.view.MainActivity;

public class AnotacoesController {
    SharedPreferences preferences;

    SharedPreferences.Editor anotacoesVip;

    public static final String NOME_PREFERENCES = "pref_anotacoesvip";

    public AnotacoesController(MainActivity mainActivity){
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        anotacoesVip = preferences.edit();
    }

    public void salvar(Anotacoes anotacoes){
        Log.d("MVC_Controlller", "Salvo" + anotacoes.toString());
        anotacoesVip.putString("tituloAnotacao", anotacoes.getTitulo());
        anotacoesVip.putString("descricaoAnotacao", anotacoes.getDescricao());
        anotacoesVip.apply();
    }

    public Anotacoes procurar(Anotacoes anotacoes){
        anotacoes.setTitulo(preferences.getString("tituloAnotacao", ""));
        anotacoes.setDescricao(preferences.getString("descricaoAnotacao", ""));
        return anotacoes;
    }

    public void limpar(){
        anotacoesVip.clear();
        anotacoesVip.apply();
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
