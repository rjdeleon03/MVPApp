package com.cpu.quikdata.Interfaces;

import android.util.Log;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.ModelsV2.Form.Form;
import com.cpu.quikdata.ModelsV2.ServerForm.ServerForm;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelMultChoiceRemarks;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
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
                .addSerializationExclusionStrategy(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {

                        if (f.getName().toLowerCase().equals("id")) {
                            return true;
                        }
                        if (f.getName().toLowerCase().contains("choices")) {
                            if (f.getDeclaringClass().equals(QuestionItemModelMultChoice.class) ||
                                    f.getDeclaringClass().equals(QuestionItemModelMultChoiceRemarks.class)) {
                                return false;
                            }
                            return true;
                        }
                        return false;
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> aClass) {
                        return false;
                    }
                })
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
    public void submitForm(Form form, Callback<ResponseBody> callback) {
        Call<ResponseBody> formCall = mService.submitForm(form);
        formCall.enqueue(callback);
    }

    /**
     * Uploads the images to the server
     * @param imagePaths
     * @param callback
     */
    public void uploadImages(String formId, List<String> imagePaths, Callback<ResponseBody> callback) {
        RequestBody formIdBody = RequestBody.create(MediaType.parse("text/plain"), formId);

        MultipartBody.Part[] files = new MultipartBody.Part[imagePaths.size()];

        int i = 0;
        for (String filename : imagePaths) {
            File file = new File(filename);
            RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);
            MultipartBody.Part bodyPart = MultipartBody.Part.createFormData("image", file.getName(), reqFile);
            files[i] = bodyPart;
            i++;
        }

        Call<ResponseBody> uploadImageCall = mService.uploadImages(files, formIdBody);
        uploadImageCall.enqueue(callback);
    }
}
