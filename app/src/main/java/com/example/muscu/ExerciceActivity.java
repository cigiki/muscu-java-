package com.example.muscu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ExerciceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice);

        // récupérer tous les boutons
        Button btnPectoraux = findViewById(R.id.btnPectoraux);
        Button btnDos = findViewById(R.id.btnDos);
        Button btnBiceps = findViewById(R.id.btnBiceps);
        Button btnTriceps = findViewById(R.id.btnTriceps);
        Button btnEpaules = findViewById(R.id.btnEpaules);
        Button btnAvantBras = findViewById(R.id.btnAvantBras);
        Button btnAbdos = findViewById(R.id.btnAbdos);
        Button btnIschioFessiers = findViewById(R.id.btnIschioFessiers);

        // clic sur Pectoraux
        btnPectoraux.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciceActivity.this, PectorauxActivity.class);
            startActivity(intent);
        });

        // clic sur Dos
        btnDos.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciceActivity.this, DosActivity.class);
            startActivity(intent);
        });

        // clic sur Biceps
        btnBiceps.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciceActivity.this, BicepsActivity.class);
            startActivity(intent);
        });

        // clic sur Triceps
        btnTriceps.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciceActivity.this, TricepsActivity.class);
            startActivity(intent);
        });

        // clic sur Épaules
        btnEpaules.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciceActivity.this, EpaulesActivity.class);
            startActivity(intent);
        });

        // clic sur Avant-bras
        btnAvantBras.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciceActivity.this, AvantBrasActivity.class);
            startActivity(intent);
        });

        // clic sur Abdos
        btnAbdos.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciceActivity.this, AbdosActivity.class);
            startActivity(intent);
        });

        // clic sur Ischio-fessiers
        btnIschioFessiers.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciceActivity.this, IschioFessiersActivity.class);
            startActivity(intent);
        });
    }
}