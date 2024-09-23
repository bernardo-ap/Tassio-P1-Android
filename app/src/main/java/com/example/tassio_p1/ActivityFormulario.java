package com.example.tassio_p1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class ActivityFormulario extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_page);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button button = findViewById(R.id.botao_calcular_juros);
        EditText montante = findViewById(R.id.montante);
        EditText taxaJuros = findViewById(R.id.taxa_juros);
        EditText tempoAnos = findViewById(R.id.tempo_anos);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityFormulario.this, ResultActivity.class);
                String montanteGet = montante.getText().toString();
                String taxaJurosGet = taxaJuros.getText().toString();
                String tempoAnosGet = tempoAnos.getText().toString();
                intent.putExtra("montante", montanteGet);
                intent.putExtra("taxaJuros", taxaJurosGet);
                intent.putExtra("tempoAnos", tempoAnosGet);
                startActivity(intent);
            }
        });
    }
}
