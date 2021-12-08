package com.example.javaandroidappexercise;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://fetch-hiring.s3.amazonaws.com/";

    public static Retrofit getRetroFitInstance() {
        //create retrofit instance
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}


