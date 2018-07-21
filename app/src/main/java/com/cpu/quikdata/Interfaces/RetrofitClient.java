package com.cpu.quikdata.Interfaces;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.ModelsV2.Form.Form;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This class is responsible for returning retrofit client instance and
 * containing relevant client data
 */
public class RetrofitClient {

    private static IRetrofitApi mService = null;
    private static RetrofitClient mClient = null;

    /**
     * Default constructor
     */
    public RetrofitClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        mService = retrofit.create(IRetrofitApi.class);
    }

    /**
     * Gets static instance of client
     * @return
     */
    public static RetrofitClient getInstance() {
        if (mClient == null) {
            mClient = new RetrofitClient();
        }
        return mClient;
    }

    /**
     * Submits a form to the server
     * @param form
     * @param callback
     */
    public void submitForm(Form form, Callback<Form> callback) {
        Call<Form> formCall = mService.submitForm(form);
        formCall.enqueue(callback);
    }
}
