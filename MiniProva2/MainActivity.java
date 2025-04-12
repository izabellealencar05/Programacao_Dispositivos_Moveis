package com.example.treinandoparaprova2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText nomeAluno;
    private EditText matriculaAluno;
    private Button botaoIniciar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        inicializarTela();
    }

    private void inicializarTela() {
        nomeAluno = findViewById(R.id.mainActivity_nome);
        matriculaAluno = findViewById(R.id.mainActivity_matricula);
        botaoIniciar = findViewById(R.id.mainActivity_botao);

        botaoIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = nomeAluno.getText().toString();
                String matricula = matriculaAluno.getText().toString();

                if (nome.isEmpty() || matricula.isEmpty()){
                    Toast.makeText(MainActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Iniciando a prova", Toast.LENGTH_SHORT).show();
                    passarProxTela();
                }
            }
        });
    }

    private void passarProxTela() {
        Intent proxTela = new Intent(this, SegundaTela.class);

        proxTela.putExtra("chaveNome", nomeAluno.getText().toString());
        proxTela.putExtra("chaveMatricula", matriculaAluno.getText().toString());


        startActivity(proxTela);

    }

}
