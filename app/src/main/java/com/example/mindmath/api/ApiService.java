package com.example.mindmath.api;

import com.example.mindmath.BaseResult;
import com.example.mindmath.NormalResult;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    //    @POST("/api/results")
    @POST("posts")
    Call<Void> sendResult(@Body NormalResult result);


}
