package com.example.muscu;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class RockyPullUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rocky_pull_up);

        ImageView imageView = findViewById(R.id.gifExercice);
        Glide.with(this)
                .load(R.drawable.rocky_pull_up)
                .into(imageView);
    }
}