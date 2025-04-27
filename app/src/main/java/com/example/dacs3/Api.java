package com.example.dacs3;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
interface Api {
    String BASE_URL = "http://192.168.1.77/banhang/";
    @GET("jsonWebservice.php")
    Call<List<Results>> getsuperHeroes();
}