package com.cristianbindea.androidfundamentals2021finalproject.retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdviceRepository {
    public static final String BASE_ADVICE_URL = "https://api.adviceslip.com/";
    private static AdviceRepository adviceRepository;
    private AdviceApi adviceApi;

    public AdviceRepository(AdviceApi adviceApi) {
        this.adviceApi = adviceApi;
    }

    public static AdviceRepository getInstance() {
        if (adviceRepository == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_ADVICE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            adviceRepository = new AdviceRepository(retrofit.create(AdviceApi.class));
        }
        return adviceRepository;
    }

    public void getAdvice(final OnGetAdviceCallback callback) {
        adviceApi.getAdvice().enqueue(new Callback<Advice>() {
            @Override
            public void onResponse(Call<Advice> call, Response<Advice> response) {
                if (response.isSuccessful()) {
                    Advice advice = response.body();
                    if (advice != null) {
                        callback.onSuccess(advice);
                    } else {
                        callback.onError();
                    }
                } else {
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<Advice> call, Throwable t) {
                callback.onError();
            }
        });

    }
}
