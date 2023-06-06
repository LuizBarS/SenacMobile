package com.example.imc.controller;

import android.content.SharedPreferences;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.imc.model.Calculadora;
import com.example.imc.view.MainActivity;

public class ImcController {
    SharedPreferences preferences;
    SharedPreferences.Editor calculoVip;
    public static final String NOME_PREFERENCES = "pref_calculovip";

    public ImcController(MainActivity mainActivity){
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        calculoVip = preferences.edit();
    }

    public void salvar(Calculadora calculadora){
        Log.d("MVC_Controller", "Salvo: " + calculadora.toString());
        calculoVip.putString("Peso", calculadora.getPeso());
        calculoVip.putString("Altura", calculadora.getAltura());
        calculoVip.apply();
    }

    public Calculadora procurar(Calculadora calculadora){
        calculadora.setPeso(preferences.getString("Peso",""));
        calculadora.setAltura(preferences.getString("Altura", ""));
        return calculadora;
    }

    public void limpar(){
        calculoVip.clear();
        calculoVip.apply();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller Iniciada...");
        return super.toString();
    }
}
