package com.example.feature_empdirectory.viewmodel;

import com.example.feature_empdirectory.adapter.EmployeeAdapter;
import com.example.repository.model.EmployeeResponse;
import com.example.repository.model.Employees;
import com.example.repository.repository.EmployeeRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EmployeeViewModel extends ViewModel {

    private MutableLiveData<EmployeeResponse> mutableLiveData;
    private EmployeeRepository employeeRepository;
    private EmployeeAdapter employeeAdapter;

    public void init(){
        if (mutableLiveData == null || mutableLiveData.getValue().getErrorHandler() != null){
            employeeRepository = EmployeeRepository.getInstance();
            mutableLiveData = employeeRepository.getEmployees();
        } else {
            return;
        }
    }

    public EmployeeAdapter getEmployeeAdapter() {
        if (employeeAdapter == null) {
            employeeAdapter = new EmployeeAdapter();
        }
        return employeeAdapter;
    }

    public void updateAdapter(List<Employees> employeeData) {
        employeeAdapter.update(employeeData);
    }

    public LiveData<EmployeeResponse> getEmployeeRepository() {
        return mutableLiveData;
    }

    public boolean isEmployeeListEmpty(List<Employees> employeeData) {
        if (employeeData.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
