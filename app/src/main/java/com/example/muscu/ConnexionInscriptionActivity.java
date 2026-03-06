package com.example.muscu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ConnexionInscriptionActivity extends AppCompatActivity {

    Button btnConnexion, btnInscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion_inscription);

        btnConnexion = findViewById(R.id.btnConnexion);
        btnInscription = findViewById(R.id.btnInscription);

        btnConnexion.setOnClickListener(v -> {
            Intent intent = new Intent(ConnexionInscriptionActivity.this, ConnexionActivity.class);
            startActivity(intent);
        });

        btnInscription.setOnClickListener(v -> {
            Intent intent = new Intent(ConnexionInscriptionActivity.this, InscriptionActivity.class);
            startActivity(intent);
        });
    }
}