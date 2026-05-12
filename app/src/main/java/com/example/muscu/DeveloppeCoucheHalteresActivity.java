package com.example.muscu;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class DeveloppeCoucheHalteresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developpe_couche_halteres);

        ImageView imageView = findViewById(R.id.gifExercice);
        Glide.with(this)
                .load(R.drawable.ecarte_couche_haltere)
                .into(imageView);
    }
}