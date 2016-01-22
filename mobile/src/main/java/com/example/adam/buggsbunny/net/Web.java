package com.example.adam.buggsbunny.net;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by adam on 1/22/16.
 */
public class Web {
    public interface LinksInterface {
        @GET("/pictures")
        Call<PicturesResponse> getUserPictures(@Field("username") String username);
    }

    private static Web INSTANCE = new Web();

    public Web() {}

    public static LinksInterface getInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(LinksInterface.class);
    }

    public void getPictures(String username) {
        Call<PicturesResponse> call = Web.getInstance().getUserPictures(username);
        call.enqueue(new Callback<PicturesResponse>() {
            @Override
            public void onResponse(Response<PicturesResponse> response, Retrofit retrofit) {
                System.out.println("Got pictures!");
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("Failed to get pictures");
            }
        });
    }

    public class PicturesResponse {

    }
}
