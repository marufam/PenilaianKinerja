package com.project.application.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by amien on 01/05/17.
 */

public class ApiClient {
    public static final String BASE_URL = "http://192.168.43.126/kinerja_res/";

    private static Retrofit retrofit = null;
    public static Retrofit GetGuru() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static ApiInterface getApiGuru(){
        return GetGuru().create(ApiInterface.class);
    }

    private static Retrofit retrofit1 = null;
    public static Retrofit GetIndikator () {
        if (retrofit1==null) {
            retrofit1 = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit1;
    }
    public static ApiInterface getApiIndikator(){
        return GetIndikator().create(ApiInterface.class);
    }

    private static Retrofit retrofit2 = null;
    public static Retrofit GetKompetensi() {
        if (retrofit2==null) {
            retrofit2 = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit2;
    }
    public static ApiInterface getApiKompetensi(){
        return GetKompetensi().create(ApiInterface.class);
    }

    private static Retrofit retrofit3 = null;
    public static Retrofit GetKomplain() {
        if (retrofit3==null) {
            retrofit3 = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit3;
    }
    public static ApiInterface getApiKomplain(){
        return GetKomplain().create(ApiInterface.class);
    }

    private static Retrofit retrofit4 = null;
    public static Retrofit GetNilai() {
        if (retrofit4==null) {
            retrofit4 = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit4;
    }
    public static ApiInterface getApiNIlai(){
        return GetNilai().create(ApiInterface.class);
    }

}
