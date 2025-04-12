package com.example.treinandoparaaprova;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ActivityMain extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        EditText nome = findViewById(R.id.nome);
        EditText senha = findViewById(R.id.senha);
        EditText nota1 = findViewById(R.id.nota1);
        EditText nota2 = findViewById(R.id.nota2);
        Button calcular = findViewById(R.id.botao);
        TextView resultado = findViewById(R.id.resultado);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nome.getText().toString().isEmpty() || senha.getText().toString().isEmpty() ||
                        nota1.getText().toString().isEmpty() || nota2.getText().toString().isEmpty()) {
                    Toast.makeText(ActivityMain.this, "Todos os campos devem estar preenchidos", Toast.LENGTH_LONG).show();
                    return;
                }
                int peso1 = 4;
                int peso2 = 6;

                double media = (Double.parseDouble(nota1.getText().toString())* peso1 + Double.parseDouble(nota2.getText().toString()) * peso2) / (peso1 + peso2);
                resultado.setText("A media final foi: " + String.format("%.2f", media));
            }
        });
    }
}
