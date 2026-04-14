package com.example.mindmath;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mindmath.databinding.ActivityTrainingBinding;

public class TrainingActivity extends AppCompatActivity {

    private ActivityTrainingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTrainingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnTraining1.setOnClickListener(v -> startActivity(new Intent(TrainingActivity.this, GameActivity.class)));
    }
}