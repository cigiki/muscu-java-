package com.example.muscu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class BicepsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biceps);


        // récupérer le bouton Curl barre
        Button btnCurlBarre = findViewById(R.id.btn_curl_barre);

        // clic sur Curl barre
        btnCurlBarre.setOnClickListener(v -> {
            Intent intent = new Intent(BicepsActivity.this, CurlBarreActivity.class);
            startActivity(intent);
        });

        Button btnRockyPullUp = findViewById(R.id.btn_rocky_pull_up);

        btnRockyPullUp.setOnClickListener(v -> {
            Intent intent = new Intent(BicepsActivity.this, RockyPullUpActivity.class);
            startActivity(intent);
        });
    }
}