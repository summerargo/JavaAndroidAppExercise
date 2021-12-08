package com.example.javaandroidappexercise;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetFetchRewardsService {
    @GET("/hiring.json")
    Call<List<FetchRewardsList>> getAllLists();
}
