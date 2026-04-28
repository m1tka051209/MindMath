package com.example.mindmath;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.mindmath.result.NormalResult;

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
            Person person = new Person();
            person.setName("User");
            person.setRole("user");
            person.setLogin("user123");
            person.setPassword("user123");
            person.setTopResult("10");
            Call<Person> call = apiService.createPerson(person);
            call.enqueue(new Callback<Person>() {
                @Override
                public void onResponse(Call<Person> call, Response<Person> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(GameActivity.this, "User created!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(GameActivity.this, "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Person> call, Throwable t) {
                    Toast.makeText(GameActivity.this, "Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });

    }
}