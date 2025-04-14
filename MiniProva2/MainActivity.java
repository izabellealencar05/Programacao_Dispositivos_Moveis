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
    //declarando as variaveis
    private EditText nomeAluno;
    private EditText matriculaAluno;
    private Button botaoIniciar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        inicializarTela(); //criando o metodo para inicializar a tela
    }

    private void inicializarTela() {
        //conectar os campos das variaveis declaradas la em cima
        nomeAluno = findViewById(R.id.mainActivity_nome);
        matriculaAluno = findViewById(R.id.mainActivity_matricula);
        botaoIniciar = findViewById(R.id.mainActivity_botao);

        //dando uma funcionalidade para o botao de iniciar
        botaoIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pegando o que foi escrito nos campos (nome e matricula) e transformando para string
                String nome = nomeAluno.getText().toString();
                String matricula = matriculaAluno.getText().toString();

                //se um campo estiver vazio aparece a mensagem
                if (nome.isEmpty() || matricula.isEmpty()){
                    Toast.makeText(MainActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Iniciando a prova", Toast.LENGTH_SHORT).show();
                    passarProxTela();
                }
            }
        });
    }
    //criando metodo para chamar a proxima tela
    private void passarProxTela() {
        //criando o intent para ir para a proxima tela,
        // This - tela de origem
        // SegundaTela.class - tela final
        Intent proxTela = new Intent(this, SegundaTela.class);

        //adicionando no intent chave para passar os dados para a proxima tela
        proxTela.putExtra("chaveNome", nomeAluno.getText().toString());
        proxTela.putExtra("chaveMatricula", matriculaAluno.getText().toString());

        //inicia a proxima tela
        startActivity(proxTela);

    }
}
