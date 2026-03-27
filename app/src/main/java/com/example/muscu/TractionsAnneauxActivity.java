package com.example.muscu;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class TractionsAnneauxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tractions_anneaux);

        ImageView imageView = findViewById(R.id.gifExercice);
        Glide.with(this)
                .load(R.drawable.tractions_aux_anneaux)
                .into(imageView);
    }
}