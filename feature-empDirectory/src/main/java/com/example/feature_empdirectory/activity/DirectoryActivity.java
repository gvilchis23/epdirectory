package com.example.feature_empdirectory.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.feature_empdirectory.R;
import com.example.feature_empdirectory.adapter.EmployeeAdapter;
import com.example.feature_empdirectory.viewmodel.EmployeeViewModel;
import com.example.repository.model.Employees;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DirectoryActivity extends AppCompatActivity {

    private List<Employees> employeeList = new ArrayList<>();
    EmployeeAdapter employeeAdapter;
    RecyclerView epRecycler;
    ProgressBar simpleProgressBar;
    EmployeeViewModel employeeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);

        simpleProgressBar = findViewById(R.id.indeterminateBar);
        epRecycler = findViewById(R.id.epDirectory);

        employeeViewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);
        employeeViewModel.init();
        //missing empty state and error data validation
        employeeViewModel.getEmployeeRepository().observe(this, EmployeeResponse -> {
            if(EmployeeResponse.getErrorHandler() != null){
                Toast.makeText(this, EmployeeResponse.getErrorHandler().getMessage(), Toast.LENGTH_SHORT).show();
            } else {
                List<Employees> employeeData = EmployeeResponse.getEmployees();
                employeeList.addAll(employeeData);
                employeeAdapter.notifyDataSetChanged();
            }
            simpleProgressBar.setVisibility(View.GONE);
        });
        setupRecyclerView();
    }


    private void setupRecyclerView() {
        if (employeeAdapter == null) {
            employeeAdapter = new EmployeeAdapter(employeeList);
            epRecycler.setAdapter(employeeAdapter);
        } else {
            employeeAdapter.notifyDataSetChanged();
        }
    }
}