package com.example.treinandoparaprova2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TerceiraTela extends AppCompatActivity {
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_terceira_tela);

        inicializaTerceiraTela(); //inicia terceira tela
    }
    private void inicializaTerceiraTela() {
        //conecta o campo com a variavel criada
        resultado = findViewById(R.id.terceiraTela_resultado);
        //cria a variavel de nota, e chama o metodo para calcular a nota
        int notaFinal = calculaNota();

        //recupera os dados da pagina anterior
        String nome = getIntent().getStringExtra("chaveNome");
        String matricula = getIntent().getStringExtra("chaveMatricula");

        //verifica a nota final do usuario e exibe uma mensagem de acordo com a nota
        if (notaFinal == 10) {
            resultado.setText("Parabéns, " + nome + " (" + matricula + ")\nVocê tirou 10 e foi aprovado(a)!");
        } else if (notaFinal == 5) {
            resultado.setText(nome + " (" + matricula + ")\nVocê tirou 5, mas foi aprovado(a)!");
        } else {
            resultado.setText(nome + " (" + matricula + ")\nInfelizmente, você foi reprovado(a).");
        }
    }
    //chama o metodo para calcular a nota
    private int calculaNota() {
        //recupera os dados das respostas da pagina anterior
        String resposta1 = getIntent().getStringExtra("chaveResposta1");
        String resposta2 = getIntent().getStringExtra("chaveResposta2");

        //faz a validacao das respostas
        if (resposta1.equals("brasilia") && resposta2.equals("roxo"))
            return 10;
        else if (resposta1.equals("brasilia") || resposta2.equals("roxo"))
            return 5;
        return 0;
    }
}
