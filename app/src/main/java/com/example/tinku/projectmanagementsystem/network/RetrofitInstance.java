package com.example.tinku.projectmanagementsystem.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by KinhangPoon on 5/3/2018.
 */

public class RetrofitInstance {

    public static final String BASE_URL = "http://rjtmobile.com/aamir/pms/android-app/";

    static Retrofit retrofit = null;

    public static Retrofit getRetrofitInstance(){
        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
