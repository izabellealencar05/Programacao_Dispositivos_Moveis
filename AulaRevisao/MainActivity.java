package com.example.aula08;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private RadioGroup pergunta1;
    private RadioGroup pergunta2;
    private Button botaoEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        inicializaTela();
    }
    private void inicializaTela() {
        pergunta1 = findViewById(R.id.activityMain_pergunta1);
        pergunta2 = findViewById(R.id.activityMain_pergunta2);
        botaoEnviar = findViewById(R.id.ActivityMain_buttonEnviar);

        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviaProva();
            }
        });
    }

    private void enviaProva() {
        String resposta1 = verificaResposta(pergunta1);
        String resposta2 = verificaResposta(pergunta2);

        Intent telaResultado = new Intent(this, TelaResultado.class);
        telaResultado.putExtra("chaveResposta1", resposta1);
        telaResultado.putExtra("chaveResposta2", resposta2);


        startActivity(telaResultado);

    }

    private String verificaResposta(RadioGroup pergunta) {
        int idOpcaoSelecionada = pergunta.getCheckedRadioButtonId();
        RadioButton radioButtonSelecionado = findViewById(idOpcaoSelecionada);
        String resposta = radioButtonSelecionado.getText().toString();
        return resposta;

    }


}
