//Alunos: Izabelle Alencar Nabarrete - 22301521
// Yago de Queiroz Pio - 22308708
package com.example.prova1_dispositivosmveis;

import android.content.Intent;
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
    private RadioGroup questao1;
    private RadioGroup questao2;
    private RadioGroup questao3;
    private Button botaoFinalizarProva;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
         iniciarProva();
    }

    private void iniciarProva() {
        questao1 = findViewById(R.id.mainActivity_RadioGroupPergunta1);
        questao2 = findViewById(R.id.mainActivity_RadioGroupPergunta2);
        questao3 = findViewById(R.id.mainActivity_RadioGroupPergunta3);
        botaoFinalizarProva = findViewById(R.id.mainActivity_botaoFinalizarProva);
        botaoFinalizarProva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questao1.getCheckedRadioButtonId() == -1 ||
                        questao2.getCheckedRadioButtonId() == -1 ||
                        questao3.getCheckedRadioButtonId() == -1) {

                    Toast.makeText(MainActivity.this, "Preencha todos os campos", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Finalizando a prova!", Toast.LENGTH_SHORT).show();
                    passarProxTela();
                }
            }
        });
    }
    private void passarProxTela() {
        String resposta1 = verificaResposta(questao1);
        String resposta2 = verificaResposta(questao2);
        String resposta3 = verificaResposta(questao3);

        Intent telaResultado = new Intent(this, TelaResultado.class);
        telaResultado.putExtra("chaveResposta1", resposta1);
        telaResultado.putExtra("chaveResposta2", resposta2);
        telaResultado.putExtra("chaveResposta3", resposta3);
        
        startActivity(telaResultado);
    }

    private String verificaResposta(RadioGroup questao) {
        int idOpcaoSelecionada = questao.getCheckedRadioButtonId();
        RadioButton radioButtonSelecionado = findViewById(idOpcaoSelecionada);
        String resposta = radioButtonSelecionado.getText().toString();
        return resposta;

    }


}
