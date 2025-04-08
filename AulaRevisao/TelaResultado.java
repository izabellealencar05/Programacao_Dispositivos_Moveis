package com.example.aula08;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaResultado extends AppCompatActivity {
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_resultado);

        inicializaTelaResultado();
    }
    private void inicializaTelaResultado() {
        resultado = findViewById(R.id.telaResultado_textViewResultado);
        int notaFinal = calculaNota();
        if (notaFinal == 10){
            resultado.setText("Parabens, voce tirou nota 10");
        } else if (notaFinal == 5){
            resultado.setText("Voce tirou nota 5");
        } else resultado.setText("nota ZERO");
    }
    private int calculaNota() {
        String resposta1 = getIntent().getStringExtra("chaveResposta1"); // captura a informação da tela de origem para a tela de destino
        String resposta2 = getIntent().getStringExtra("chaveResposta2");
        if(resposta1.equals("d - whashington") && resposta2.equals("d - jupiter"))
            return 10;
        else if (resposta1.equals("d - whashington") || resposta2.equals("d - jupiter"))
            return 5;
        return 0;
    }
}
