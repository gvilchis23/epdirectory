package com.example.feature_empdirectory.viewmodel;

import com.example.repository.model.EmployeeResponse;
import com.example.repository.repository.EmployeeRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EmployeeViewModel extends ViewModel {

    private MutableLiveData<EmployeeResponse> mutableLiveData;
    private EmployeeRepository employeeRepository;

    public void init(){
        if (mutableLiveData == null || mutableLiveData.getValue().getErrorHandler() != null){
            employeeRepository = EmployeeRepository.getInstance();
            mutableLiveData = employeeRepository.getEmployees();
        } else {
            return;
        }
    }

    public LiveData<EmployeeResponse> getEmployeeRepository() {
        return mutableLiveData;
    }


}
