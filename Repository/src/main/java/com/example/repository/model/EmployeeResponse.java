
package com.example.repository.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeResponse {

    @SerializedName("employees")
    private List<Employees> employees = null;
    private Error errorHandler;

    public EmployeeResponse() {
    }

    public EmployeeResponse(List<Employees> employees, Error errorHandler) {
        this.employees = employees;
        this.errorHandler = errorHandler;
    }
    public EmployeeResponse(List<Employees> employees) {
        this.employees = employees;
    }

    public EmployeeResponse(Error errorHandler) {
        this.errorHandler = errorHandler;
    }


    public List<Employees> getEmployees() {
            return employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }

    public Error getErrorHandler() {
        return errorHandler;
    }

    public void setErrorHandler(Error errorHandler) {
        this.errorHandler = errorHandler;
    }
}
