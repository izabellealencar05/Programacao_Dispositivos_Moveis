package com.example.aula07;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioGroup pergunta1;
    private Button checar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        inicializaTela();

    }

    private void inicializaTela() {
        pergunta1 = findViewById(R.id.radioGroup);
        checar = findViewById(R.id.button);

        checar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int opcaoSelecionada = pergunta1.getCheckedRadioButtonId();
                RadioButton respostaUsuario = findViewById(opcaoSelecionada);
                String resposta = respostaUsuario.getText().toString();

                Toast.makeText(MainActivity.this, "A opcao selecionada foi: " +
                        resposta, Toast.LENGTH_LONG).show();}
        });


    }
}
