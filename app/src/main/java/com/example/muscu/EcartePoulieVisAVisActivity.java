package com.example.muscu;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class EcartePoulieVisAVisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecarte_poulie_vis_a_vis);

        ImageView imageView = findViewById(R.id.gifExercice);
        Glide.with(this)
                .load(R.drawable.ecarte_poulie_vis_a_vis_exercice_musculation_pectoraux)
                .into(imageView);
    }
}