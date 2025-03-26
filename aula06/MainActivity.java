package com.example.aula6_parte2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

//    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    public - acessivel por qualquer classe, seja no mesmo pacote ou nao
//    protected - acessivel por qualquer classe, desde que no mesmo pacote
//    private - acessivel somente dentro da propria classe
//    vazio - acessivel por qualquer classe no mesmo pacote

//    não da pra mudar o textView, deve declara-la fora do metodo (protected) ou delcrar num metodo privado
//    ir no onclick do proprio botao no activity_main
    public void clickButton(View view){
        TextView textView = findViewById(R.id.textView);
        textView.setText("O botao foi acionado");
    }
}
