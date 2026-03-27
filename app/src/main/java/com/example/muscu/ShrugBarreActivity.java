package com.example.muscu;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class ShrugBarreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shrug_barre);

        ImageView imageView = findViewById(R.id.gifShrugBarre);
        Glide.with(this)
                .load(R.drawable.shrug_barre)
                .into(imageView);
    }
}