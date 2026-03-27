package com.example.muscu;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class TractionSupinationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traction_supination);

        ImageView imageView = findViewById(R.id.gifTractionSupination);
        Glide.with(this)
                .load(R.drawable.chin_up_traction_supination)
                .into(imageView);
    }
}