package com.example.newchallenge;

import com.example.newchallenge.Models.Repo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestInterface {

    @GET("android/doctors.json")
    Call<Repo> getDoctors();

}
