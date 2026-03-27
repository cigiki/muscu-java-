package com.example.muscu;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class RowingHaltereUnBrasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rowing_haltere_un_bras);

        ImageView imageView = findViewById(R.id.gifRowingHaltereUnBras);
        Glide.with(this)
                .load(R.drawable.rowing_haltere_un_bras)
                .into(imageView);
    }
}