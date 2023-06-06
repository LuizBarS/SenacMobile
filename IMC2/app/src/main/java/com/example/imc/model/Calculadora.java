package com.example.imc.model;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Calculadora {
    private String altura;
    private String peso;

    public Calculadora() {
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Calculadora{" +
                "altura='" + altura + '\'' +
                ", peso='" + peso + '\'' +
                '}';
    }
}
