package com.example.burritoquest.Services;


import com.example.burritoquest.BuildConfig;
import com.example.burritoquest.Model.GoogleResult;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GoogleService {

    private GoogleInterface googleInterface;

    public GoogleService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        googleInterface = retrofit.create(GoogleInterface.class);

    }

    public Call<GoogleResult> googleResultCall(String location, String pageToken) {
        return googleInterface.firstGoogleResultCall(5000, "restaurant", "burrito", BuildConfig.ApiKey, location, pageToken);
    }
}


