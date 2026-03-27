package com.example.muscu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class DosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos);

        // récupérer tous les boutons
        Button btnTractionsAnneaux = findViewById(R.id.btn_tractions_anneaux);
        Button btnDeadHang = findViewById(R.id.btn_dead_hang);
        Button btnMuscleUp = findViewById(R.id.btn_muscle_up);
        Button btnTraction = findViewById(R.id.btn_traction);
        Button btnTirageHorizontal = findViewById(R.id.btn_tirage_horizontal);
        Button btnRowingBarre = findViewById(R.id.btn_rowing_barre);
        Button btnShrugBarre = findViewById(R.id.btn_shrug_barre);
        Button btnPullOver = findViewById(R.id.btn_pull_over);
        Button btnTractionSupination = findViewById(R.id.btn_traction_supination);
        Button btnRowingHaltere = findViewById(R.id.btn_rowing_haltere);

        // clic sur Tractions aux anneaux
        btnTractionsAnneaux.setOnClickListener(v -> {
            Intent intent = new Intent(DosActivity.this, TractionsAnneauxActivity.class);
            startActivity(intent);
        });

        // clic sur Dead Hang
        btnDeadHang.setOnClickListener(v -> {
            Intent intent = new Intent(DosActivity.this, DeadHangActivity.class);
            startActivity(intent);
        });

        // clic sur Muscle-up
        btnMuscleUp.setOnClickListener(v -> {
            Intent intent = new Intent(DosActivity.this, MuscleUpActivity.class);
            startActivity(intent);
        });

        // clic sur Traction
        btnTraction.setOnClickListener(v -> {
            Intent intent = new Intent(DosActivity.this, TractionActivity.class);
            startActivity(intent);
        });

        // clic sur Tirage horizontal
        btnTirageHorizontal.setOnClickListener(v -> {
            Intent intent = new Intent(DosActivity.this, TirageHorizontalActivity.class);
            startActivity(intent);
        });

        // clic sur Rowing barre
        btnRowingBarre.setOnClickListener(v -> {
            Intent intent = new Intent(DosActivity.this, RowingBarreActivity.class);
            startActivity(intent);
        });

        // clic sur Shrug barre
        btnShrugBarre.setOnClickListener(v -> {
            Intent intent = new Intent(DosActivity.this, ShrugBarreActivity.class);
            startActivity(intent);
        });

        // clic sur Pull-over
        btnPullOver.setOnClickListener(v -> {
            Intent intent = new Intent(DosActivity.this, PullOverActivity.class);
            startActivity(intent);
        });

        // clic sur Traction supination
        btnTractionSupination.setOnClickListener(v -> {
            Intent intent = new Intent(DosActivity.this, TractionSupinationActivity.class);
            startActivity(intent);
        });

        // clic sur Rowing haltère
        btnRowingHaltere.setOnClickListener(v -> {
            Intent intent = new Intent(DosActivity.this, RowingBarreActivity.class);
            startActivity(intent);
        });
    }
}