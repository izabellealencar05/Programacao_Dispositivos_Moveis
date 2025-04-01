package com.example.exercicioaula06;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Segundatela extends AppCompatActivity {
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda_tela);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inicializaSegundaTela();
    }

    private void inicializaSegundaTela(){
        resultado = findViewById(R.id.segundatela_textViewResultado);
        String nome = getIntent().getStringExtra("chaveNome");
        String matricula = getIntent().getStringExtra("chaveMatricula");
        String nota1 = getIntent().getStringExtra("chaveNota");
        String nota2 = getIntent().getStringExtra("chaveNota2");

        calculaMediaFinal(nota1, nota2);
        double mediaFinal = calculaMediaFinal(nota1, nota2);

        resultado.setText("Bem Vindo: " + nome + "\nMatricula" + matricula +
                "\nSua media final foi: " + mediaFinal);
    }

    private double calculaMediaFinal(String nota1, String nota2) {
         double nota1Convertida = Double.parseDouble(nota1);
         double nota2Convertida = Double.parseDouble(nota2);

        double notaFinal = (nota1Convertida * 0.4) + (nota2Convertida * 0.6);
        return notaFinal;
    }


}
