package com.cpu.quikdata.Interfaces;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.ModelsV2.Form.Form;
import com.cpu.quikdata.ModelsV2.ServerForm.ServerForm;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface IRetrofitApi {

    @POST(AppConstants.ROUTE_DNCA)
    Call<ResponseBody> submitForm(@Body Form form);

    @Multipart
    @POST(AppConstants.ROUTE_IMAGES)
    Call<ResponseBody> uploadImages(@Part MultipartBody.Part[] image, @Part("form_id") RequestBody formId);
}
