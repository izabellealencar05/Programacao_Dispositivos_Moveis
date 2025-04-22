//Alunos: Izabelle Alencar Nabarrete - 22301521
// Yago de Queiroz Pio - 22308708
package com.example.prova1_dispositivosmveis;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class TelaResultado extends AppCompatActivity {
    private TextView titulo;
    private TextView nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_resultado);
         iniciarTelaResultado();
    }

    private void iniciarTelaResultado() {
        titulo = findViewById(R.id.telaResultado_tituloResultado);
        nota = findViewById(R.id.telaResultado_notaFinal);

        int notaFinal = calculaNota();

        if (notaFinal == 10){
            nota.setText("Parabens! Sua nota foi 10!");
        } else if (notaFinal == 6){
            nota.setText("Você passou com nota 6");
        } else if (notaFinal == 3){
            nota.setText("Você reprovou, nota 3");
        }else {
            nota.setText("Reprovou, nota 0");
        }
    }
    private int calculaNota() {
        String resposta1 = getIntent().getStringExtra("chaveResposta1");
        String resposta2 = getIntent().getStringExtra("chaveResposta2");
        String resposta3 = getIntent().getStringExtra("chaveResposta3");

        int acertos = 0;

        if ("Verdadeiro".equals(resposta1)) {
            acertos++;
        }
        if ("Verdadeiro".equals(resposta2)) {
            acertos++;
        }
        if ("Falso".equals(resposta3)) {
            acertos++;
        }

        if (acertos == 3) {
            return 10;
        } else if (acertos == 2) {
            return 6;
        } else if (acertos == 1) {
            return 3;
        } else {
            return 0;
        }
    }
}
