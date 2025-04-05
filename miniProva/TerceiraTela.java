package com.example.exercicioaula07;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TerceiraTela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_terceira_tela);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        int pontuacao = intent.getIntExtra("pontuacao", 0);
        String nomeDoAluno = intent.getStringExtra("chaveNome");
        String questoesErradas = intent.getStringExtra("questoesErradas");

        TextView pontuacaoObtida = findViewById(R.id.pontuacao);

        String resultadoFinal = "Bom trabalho, " + nomeDoAluno + "! \nSua pontuação final foi: " + pontuacao;

        if (questoesErradas != null && !questoesErradas.isEmpty()) {
            resultadoFinal += "\nVocê errou a " + questoesErradas;
        } else {
            resultadoFinal += "\nParabéns! Você acertou tudo!";
        }

        pontuacaoObtida.setText(resultadoFinal);
    }
}
