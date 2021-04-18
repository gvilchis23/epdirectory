package com.example.repository.service;



import com.example.repository.api.EmployeeApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by memoPilgrim on 04/17/21.
 */

public class RetrofitService {

    private static RetrofitService instance = null;
    private EmployeeApi employeeApi;

    private RetrofitService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(employeeApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        employeeApi = retrofit.create(EmployeeApi.class);
    }

    public static synchronized RetrofitService getInstance() {
        if (instance == null) {
            instance = new RetrofitService();
        }
        return instance;
    }

    public EmployeeApi getEmployeeApi() {
        return employeeApi;
    }
}
