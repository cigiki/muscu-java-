package com.example.muscu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnExercice, btnPlanning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnExercice = findViewById(R.id.btnExercice);
        btnPlanning = findViewById(R.id.btnPlanning);

        btnExercice.setOnClickListener(v -> {
            // Page exercices (à créer plus tard)
            startActivity(new Intent(MainActivity.this, ExerciceActivity.class));
        });

        btnPlanning.setOnClickListener(v -> {
            // Page connexion inscription (à créer plus tard)
            startActivity(new Intent(MainActivity.this, ConnexionInscriptionActivity.class));
        });
    }
}