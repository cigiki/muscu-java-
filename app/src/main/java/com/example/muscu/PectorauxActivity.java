package com.example.muscu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class PectorauxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pectoraux);

        // récupérer tous les boutons
        Button btnDeveloppeCoucheBarre = findViewById(R.id.btn_developpe_couche_barre);
        Button btnDeveloppeCoucheHalteres = findViewById(R.id.btn_developpe_couche_halteres);
        Button btnEcartePoulieVisAVis = findViewById(R.id.btn_ecarte_poulie_vis_a_vis);

        // clic sur Développé couché barre
        btnDeveloppeCoucheBarre.setOnClickListener(v -> {
            Intent intent = new Intent(PectorauxActivity.this, DeveloppeCoucheBarreActivity.class);
            startActivity(intent);
        });

        // clic sur Développé couché haltères
        btnDeveloppeCoucheHalteres.setOnClickListener(v -> {
            Intent intent = new Intent(PectorauxActivity.this, DeveloppeCoucheHalteresActivity.class);
            startActivity(intent);
        });

        // clic sur Écarté à la poulie vis-à-vis
        btnEcartePoulieVisAVis.setOnClickListener(v -> {
            Intent intent = new Intent(PectorauxActivity.this, EcartePoulieVisAVisActivity.class);
            startActivity(intent);
        });
    }
}