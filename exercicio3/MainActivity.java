package com.example.exercicio3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("tela de cadastro"); //criando a header da tela
        setContentView(R.layout.relative_layout);

        EditText nome = findViewById(R.id.nome);
        EditText email = findViewById(R.id.email);
        EditText telefone = findViewById(R.id.telefone);
        EditText cpf = findViewById(R.id.cpf);

        Button salvar = findViewById(R.id.button);
        Button cancelar = findViewById(R.id.button2);

        TextView resultadoFinal = findViewById(R.id.textView);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome.setText("");
                email.setText("");
                telefone.setText(" ");
                cpf.setText("");

                resultadoFinal.setText("");
            }
        });
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeRecebido = nome.getText().toString();
                String emailRecebido = email.getText().toString();
                String cpfRecebido = cpf.getText().toString();
                String telefoneRecebido = telefone.getText().toString();

                resultadoFinal.setText("Os dados informados foram: "
                        + nomeRecebido + " " + cpfRecebido + " " +
                        emailRecebido + " " + telefoneRecebido);
            }
        });
    }
}
