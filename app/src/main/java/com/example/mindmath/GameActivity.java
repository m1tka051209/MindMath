package com.example.mindmath;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.mindmath.NormalResult;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mindmath.api.ApiService;
import com.example.mindmath.api.RetrofitClient;
import com.example.mindmath.databinding.ActivityGameBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameActivity extends AppCompatActivity {

    private ActivityGameBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);


        binding.btnTest.setOnClickListener(v -> {
            Toast.makeText(this, "Кнопка работает", Toast.LENGTH_SHORT).show();
            NormalResult testResult = new NormalResult();
            testResult.setUserId(1);
            testResult.setMode("normal");
            testResult.setGrade(2);
            testResult.setTotalQuestions(10);
            testResult.setCorrectAnswers(7);
            testResult.setWrongAnswers(3);
            testResult.setDurationSeconds(125);
            testResult.setTimestamp(System.currentTimeMillis());

            Call<Void> call = apiService.sendResult(testResult);
            call.enqueue(new Callback<>() {
                @Override
                public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(GameActivity.this, "Отправлено!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(GameActivity.this, "Ошибка: " + response.code(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                    Toast.makeText(GameActivity.this, "Не удалось отправить: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("sendResult", "onFailure: " + t.getMessage());
                }
            });
        });

    }
}