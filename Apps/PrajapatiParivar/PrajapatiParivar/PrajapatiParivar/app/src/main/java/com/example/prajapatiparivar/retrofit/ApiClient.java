package com.example.prajapatiparivar.retrofit;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2/26/2018.
 */

public class ApiClient {
/*    private static final String ROOT_URL = "http://192.168.0.22/api_prajapatiParivar/";
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static ApiInterface getApiService() {
        return getRetrofitInstance().create(ApiInterface.class);
    }*/


    public static final String BASE_URL = "http://192.168.43.157/api_prajapatiParivar/";

    public static final String BASE_URL1 = "http://192.168.43.157/api_prajapatiParivar/imageUpload/";
    public static final String IMG_URL_MOBILE = "http://192.168.43.157/api_prajapatiParivar/";



/*
 public static final String BASE_URL = "https://kumkum8140.000webhostapp.com/";

    public static final String BASE_URL1 = "https://kumkum8140.000webhostapp.com/?dir=imageUpload/";
    public static final String IMG_URL_MOBILE ="https://kumkum8140.000webhostapp.com/";
*/

    private static Retrofit retrofit = null;

   /* public static Retrofit getClient() {
            if (retrofit==null) {
                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                     //   .client(client)

                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            }
            return retrofit;
        }
*/



      /*  public static Retrofit getClient() {


                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

            return retrofit;
        }*/
      public static Retrofit getClient() {
          if (retrofit==null) {
              Gson gson = new GsonBuilder()
                      .setLenient()
                      .setDateFormat("yyyy-MM-dd")
                      .create();

              retrofit = new Retrofit.Builder()
                      .baseUrl(BASE_URL)
                      .addConverterFactory(GsonConverterFactory.create(gson))
                      .build();
          }
          return retrofit;
      }
}