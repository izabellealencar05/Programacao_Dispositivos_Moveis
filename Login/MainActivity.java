package com.example.treinandorelative;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView frase = findViewById(R.id.textView);
        EditText nome = findViewById(R.id.editTextText);
        EditText senha = findViewById(R.id.editTextTextPassword);
        Button entrar = findViewById(R.id.button);

        frase.setText("Login do Usuário");

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nome.getText().toString().equals("admin") &&  senha.getText().toString().equals("admin")){
                    Toast.makeText(MainActivity.this, "Login efetuado com sucesso",
                            Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(MainActivity.this, "Login incorreto",
                            Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
