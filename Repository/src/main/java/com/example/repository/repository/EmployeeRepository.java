package com.example.repository.repository;

import com.example.repository.api.EmployeeApi;
import com.example.repository.model.EmployeeResponse;
import com.example.repository.service.RetrofitService;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeRepository {

    private static EmployeeRepository employeeRepository;

    public static EmployeeRepository getInstance(){
        if (employeeRepository == null){
            employeeRepository = new EmployeeRepository();
        }
        return employeeRepository;
    }

    private EmployeeApi employeeApi;

    public EmployeeRepository(){
        employeeApi = RetrofitService.getInstance().getEmployeeApi();
    }

    public MutableLiveData<EmployeeResponse> getEmployees(){
        MutableLiveData<EmployeeResponse> employeeData = new MutableLiveData<>();
        employeeApi.getEmployeeList().enqueue(new Callback<EmployeeResponse>() {
            @Override
            public void onResponse(Call<EmployeeResponse> call, Response<EmployeeResponse> response) {
                if (response.isSuccessful()){
                    employeeData.setValue(response.body());
                } else  {
                    //this can be handle with a wrapper class and a generics.
                    employeeData.setValue(new EmployeeResponse(new Error("HTTP Error from server",null)));
                }
            }

            @Override
            public void onFailure(Call<EmployeeResponse> call, Throwable t) {
                employeeData.setValue(new EmployeeResponse(new Error(t.getMessage(),t)));
            }
        });
        return employeeData;
    }
}
