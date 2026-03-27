package com.example.muscu;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class PullOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_over);

        ImageView imageView = findViewById(R.id.gifPullOver);
        Glide.with(this)
                .load(R.drawable.musculation_pull_over_assis_machine)
                .into(imageView);
    }
}