package developer.android.santos.gerenciamentotarefas.view;

import androidx.appcompat.app.AppCompatActivity;

import developer.android.santos.gerenciamentotarefas.R;
import developer.android.santos.gerenciamentotarefas.controller.TarefasController;
import developer.android.santos.gerenciamentotarefas.model.Tarefas;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TarefasController controller;

    Tarefas tarefas;

    EditText txt_Titulo;
    EditText txt_Descricao;
    EditText txt_Data;

    Button btnSalvar;
    Button btn_Limpar;
    Button btnConcluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new TarefasController(MainActivity.this);

        tarefas = new Tarefas();
        controller.procurar(tarefas);

        txt_Titulo = findViewById(R.id.txt_Titulo);
        txt_Descricao = findViewById(R.id.txt_Descricao);
        txt_Data = findViewById(R.id.txt_Data);

        btn_Limpar = findViewById(R.id.btn_Limpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnConcluir = findViewById(R.id.btnConcluir);

        txt_Titulo.setText(tarefas.getNomeTarefa());
        txt_Descricao.setText(tarefas.getDescTarefa());
        txt_Data.setText(tarefas.getDataConclusao());

        btn_Limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Dados informados limpados com sucesso", Toast.LENGTH_LONG).show();
                txt_Titulo.setText("");
                txt_Descricao.setText("");
                txt_Data.setText("");
                controller.limpar();
            }
        });

        btnConcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Tarefa concluida com sucesso", Toast.LENGTH_SHORT).show();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tarefas.setNomeTarefa(txt_Titulo.getText().toString());
                tarefas.setDescTarefa(txt_Descricao.getText().toString());
                tarefas.setDataConclusao(txt_Data.getText().toString());

                Toast.makeText(MainActivity.this, "Dados salvos com sucesso" + tarefas.toString(), Toast.LENGTH_LONG).show();

                controller.salvar(tarefas);
            }
        });
    }
}