package com.example.mindmath;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mindmath.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, windowInsets) -> {
            Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
            Insets cutout = windowInsets.getInsets(WindowInsetsCompat.Type.displayCutout());

            int topInset = insets.top + cutout.top;

            binding.getRoot().setPadding(0, topInset - 15, 0, 0);

            binding.contentScrollContainer.setPadding(
                    binding.contentScrollContainer.getPaddingLeft(),
                    binding.contentScrollContainer.getPaddingTop(),
                    binding.contentScrollContainer.getPaddingRight(),
                    insets.bottom + 40
            );

            return windowInsets;
        });

        binding.btnHi.setOnClickListener(view -> {
           Intent intent = new Intent(MainActivity.this, TrainingActivity.class);
           startActivity(intent);
        });
    }




}