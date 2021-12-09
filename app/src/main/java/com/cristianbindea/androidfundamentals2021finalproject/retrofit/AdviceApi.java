package com.cristianbindea.androidfundamentals2021finalproject.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AdviceApi {
    @GET("/advice")
    Call<Advice> getAdvice();
}
