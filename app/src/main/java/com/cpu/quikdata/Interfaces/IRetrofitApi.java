package com.cpu.quikdata.Interfaces;

import com.cpu.quikdata.ModelsV2.Form.Form;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IRetrofitApi {

    @POST("/api/dnca")
    Call<Form> submitForm(@Body Form form);
}
