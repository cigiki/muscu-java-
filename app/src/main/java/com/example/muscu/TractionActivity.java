package com.example.muscu;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class TractionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traction);

        ImageView imageView = findViewById(R.id.gifTraction);
        Glide.with(this)
                .load(R.drawable.traction_musculation_dos)
                .into(imageView);
    }
}