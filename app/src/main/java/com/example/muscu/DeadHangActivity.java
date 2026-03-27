package com.example.muscu;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class DeadHangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dead_hang);

        ImageView imageView = findViewById(R.id.gifDeadHang);
        Glide.with(this)
                .load(R.drawable.dead_hang_suspension_passive)
                .into(imageView);
    }
}