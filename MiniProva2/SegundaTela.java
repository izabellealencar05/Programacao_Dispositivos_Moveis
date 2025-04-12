package com.example.treinandoparaprova2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SegundaTela extends AppCompatActivity {
    private RadioGroup pergunta1;
    private RadioGroup pergunta2;
    private Button terminarProva;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda_tela);

        iniciarProva();
    }
    private void iniciarProva() {
        pergunta1 = findViewById(R.id.segundaTela_Questao1);
        pergunta2 = findViewById(R.id.segundaTela_questao2);
        terminarProva = findViewById(R.id.segundaTela_botaoEnviarProva);

        terminarProva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviaProva();
            }
        });
    }
    private void enviaProva() {
        String resposta1 = verificaResposta(pergunta1);
        String resposta2 = verificaResposta(pergunta2);

        String nome = getIntent().getStringExtra("chaveNome");
        String matricula = getIntent().getStringExtra("chaveMatricula");

        Intent telaResultado = new Intent(this, TerceiraTela.class);
        telaResultado.putExtra("chaveResposta1", resposta1);
        telaResultado.putExtra("chaveResposta2", resposta2);
        telaResultado.putExtra("chaveNome", nome);
        telaResultado.putExtra("chaveMatricula", matricula);

        startActivity(telaResultado);
    }


    private String verificaResposta(RadioGroup pergunta) {
        int idOpcaoSelecionada = pergunta.getCheckedRadioButtonId();
        RadioButton radioButtonSelecionado = findViewById(idOpcaoSelecionada);
        String resposta = radioButtonSelecionado.getText().toString();
        return resposta;
    }


}
