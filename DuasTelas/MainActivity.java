package com.example.exercicioaula06;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
//    modificadores de acesso:
//    Valem para metodo e para atributos
//    - Public = pode ser acessado por qualquer classe em qualquer pacote
//    - Protected = pode ser acessado por qualquer classe porem dentro do mesmo pacote (pode ser acessado por subpacotes tambem)
//    - Private = pode ser acessado apenas dentro da classe que esta definido
//    - Default (sem nada) = pode ser acessado apenas por clsses no mesmo pacote

//    encapsulamento
    private EditText nome;
    private EditText matricula;
    private EditText nota1;
    private EditText nota2;
    private Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        inicializaTela();
    }

    private void inicializaTela() {
        nome = findViewById(R.id.nomeAluno);
        matricula = findViewById(R.id.matriculaAluno);
        nota1 = findViewById(R.id.notaAluno);
        nota2 = findViewById(R.id.notaAluno2);
        calcular = findViewById(R.id.Calcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passarProxtela();
            }
        });

    }

    private void passarProxtela() {
//        this = tela de origem, Segundatela = tela de destino
        Intent proxTela = new Intent(this, Segundatela.class);
//        pode fazer assim:
//        proxTela.putExtra("chaveNome", nome.getText().toString());
//        ou assim:
        String nomeRecebido = nome.getText().toString();
        String matriculaRecebida = matricula.getText().toString();
        String notaRecebida = nota1.getText().toString();
        String nota2Recebida = nota2.getText().toString();

        proxTela.putExtra("chaveNome", nomeRecebido);
        proxTela.putExtra("chaveMatricula", matriculaRecebida);
        proxTela.putExtra("chaveNota", notaRecebida);
        proxTela.putExtra("chaveNota2", nota2Recebida);

        startActivity(proxTela);

    }

    public void chamasegundatela(View view){

        String nomeInformado = nome.getText().toString();
        String matriculaInformada = matricula.getText().toString();
        String notaInformada = nota1.getText().toString();
        String nota2Informada = nota2.getText().toString();

        Intent meuIntent = new Intent(this, com.example.exercicioaula06.Segundatela.class);

        meuIntent.putExtra("nomeDoUsuario", nomeInformado);
        meuIntent.putExtra("MatriculaDoUsuario", matriculaInformada);
        meuIntent.putExtra("notaDoUsuario", notaInformada);
        meuIntent.putExtra("nota2DoUsuario", nota2Informada);

        startActivity(meuIntent);
    }
}
