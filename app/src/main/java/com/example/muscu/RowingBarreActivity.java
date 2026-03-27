package com.example.muscu;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class RowingBarreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rowing_barre);

        ImageView imageView = findViewById(R.id.gifRowingBarre);
        Glide.with(this)
                .load(R.drawable.rowing_barre)
                .into(imageView);
    }
}