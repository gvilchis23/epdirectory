package com.example.repository.api;


import com.example.repository.model.EmployeeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;


/**
 * Created by memoPilgrim on 04/17/21.
 */

public interface EmployeeApi {

     String BASE_URL = "https://s3.amazonaws.com/sq-mobile-interview/";

    @Headers({
            "Accept:text/plain"
    })
    @GET("employees.json")
    Call <EmployeeResponse> getEmployeeList();

    @GET("employees_empty.json")
    Call <EmployeeResponse> getEmployeeEmptyList();

    @GET("employees_malformed.json")
    Call <EmployeeResponse> getEmployeeMalformedList();

}
