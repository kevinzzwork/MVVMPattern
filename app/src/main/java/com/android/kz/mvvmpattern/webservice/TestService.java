package com.android.kz.mvvmpattern.webservice;

import com.android.kz.mvvmpattern.webservice.response.DateTimeResponse;

import retrofit.Call;
import retrofit.http.GET;

/**
 * User: Kevin
 * Date: 14/09/15
 * Time: 10:03 PM
 */
public interface TestService {

    @GET("/")
    Call<DateTimeResponse> getDate();

}
