package com.example.aula6_constraint;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText nome = findViewById(R.id.editTextText);
        EditText matricula = findViewById(R.id.editTextText2);
        EditText nota1 = findViewById(R.id.editTextNota1);
        EditText nota2 = findViewById(R.id.editTextNota2);
        Button calcular = findViewById(R.id.button);
        TextView resultado = findViewById(R.id.textView);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nota1Informada = nota1.getText().toString();
                String nota2Informada = nota2.getText().toString();

                float nota1Calc = Float.parseFloat(nota1Informada);
                float nota2Calc = Float.parseFloat(nota2Informada);

                double mediaFinal = (nota1Calc * 0.4) + (nota2Calc * 0.6);

                resultado.setText("O resultado da media ponderada é: " + mediaFinal);

            }
        });
    }
}
