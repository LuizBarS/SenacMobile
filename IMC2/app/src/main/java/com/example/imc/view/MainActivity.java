package com.example.imc.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imc.R;
import com.example.imc.controller.ImcController;
import com.example.imc.model.Calculadora;

public class MainActivity extends AppCompatActivity {
    ImcController controller;

    Calculadora calculadora;

    EditText edit_Peso;
    EditText edit_Altura;

    Button btnLimpar;
    Button btnSalvar;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new ImcController(MainActivity.this);

        calculadora = new Calculadora();
        controller.procurar(calculadora);

        edit_Peso = findViewById(R.id.editPeso);
        edit_Altura = findViewById(R.id.editAltura);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnCalcular = findViewById(R.id.btnCalcular);

        edit_Peso.setText(calculadora.getPeso());
        edit_Altura.setText(calculadora.getAltura());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Informações Limpadas com sucesso !", Toast.LENGTH_LONG).show();
                edit_Peso.setText("");
                edit_Altura.setText("");
                controller.limpar();
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Informações calculadas com sucesso !", Toast.LENGTH_LONG).show();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculadora.setPeso(edit_Peso.getText().toString());
                calculadora.setAltura(edit_Altura.getText().toString());

                Toast.makeText(MainActivity.this, "Dados salvos com sucesso" + calculadora.toString(), Toast.LENGTH_LONG).show();

                controller.salvar(calculadora);
            }
        });
    }
}