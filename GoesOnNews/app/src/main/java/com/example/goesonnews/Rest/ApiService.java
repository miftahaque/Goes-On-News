package com.example.goesonnews.Rest;

import com.example.goesonnews.Model.NewsModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("top-headlines?country=id&category=business&apiKey=12850cd010b54441aaeff6749dc99cd0") //endpoint
    Call<NewsModel> getData();

}
