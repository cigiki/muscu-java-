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

        // bouton exercices
        btnExercice.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ExerciceActivity.class);
            startActivity(intent);
        });

        // bouton planning
        btnPlanning.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ConnexionInscriptionActivity.class);
            startActivity(intent);
        });
    }
}