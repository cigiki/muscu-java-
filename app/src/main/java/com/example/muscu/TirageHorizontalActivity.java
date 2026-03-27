package com.example.muscu;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class TirageHorizontalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tirage_horizontal);

        ImageView imageView = findViewById(R.id.gifTirageHorizontal);
        Glide.with(this)
                .load(R.drawable.tirage_horizontal_poulie)
                .into(imageView);
    }
}