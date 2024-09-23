package com.example.tassio_p1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.text.DecimalFormat;

public class ResultActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_page);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        String montante = intent.getStringExtra("montante");
        String taxaJuros = intent.getStringExtra("taxaJuros");
        String tempoAnos = intent.getStringExtra("tempoAnos");

        DecimalFormat formatacao = new DecimalFormat("0.00");

        float fv = Float.parseFloat(montante);
        float i = (Float.parseFloat(taxaJuros) / 100) / 12;
        int n = Integer.parseInt(tempoAnos) * 12;

        double finalResult = fv * i  / (Math.pow((1 + i), n) - 1);

        TextView textValor1Input = findViewById(R.id.valorResultado);
        textValor1Input.setText(formatacao.format(finalResult));

        Button button = findViewById(R.id.botao_voltar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, ActivityFormulario.class);
                startActivity(intent);
            }
        });
    }
}
