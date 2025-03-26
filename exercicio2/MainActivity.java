package com.example.exercicio2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TextView frase1= findViewById(R.id.textView2); //TextView uma frase fixa, que nao da pra digitar
        TextView frase2 = findViewById(R.id.textView);
        TextView frase3 = findViewById(R.id.textView3);

        Button ok = findViewById(R.id.button); //renomeando a variavel
        EditText nome = findViewById(R.id.editTextText); //EditTextcaixa para inserir dados
        EditText email = findViewById(R.id.editTextText2);
        frase1.setText("PROGRAMACAO PARA DISPOSITIVOS MOVEIS"); //adicionando uma frase para o textview
        frase2.setText("Linear Layout");
        frase3.setText("izabelle alencar nabarrete");


        ok.setOnClickListener(new View.OnClickListener() { //adicionando uma logica para o botao
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        nome.getText().toString()
                                + " - " + email.getText().toString(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}


