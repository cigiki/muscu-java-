package com.example.muscu;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class MuscleUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_up);

        ImageView imageView = findViewById(R.id.gifMuscleUp);
        Glide.with(this)
                .load(R.drawable.muscle_up_calisthenics_street_workout_dos)
                .into(imageView);
    }
}