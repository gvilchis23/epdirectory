package com.example.feature_empdirectory.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.feature_empdirectory.R;
import com.example.feature_empdirectory.viewmodel.EmployeeViewModel;
import com.example.repository.model.Employees;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by memoPilgrim on 04/17/21.
 * */

public class DirectoryActivity extends AppCompatActivity {

    RecyclerView epRecycler;
    ProgressBar simpleProgressBar;
    TextView emptyTextView;
    EmployeeViewModel employeeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);
        simpleProgressBar = findViewById(R.id.indeterminateBar);
        epRecycler = findViewById(R.id.epDirectory);
        emptyTextView = findViewById(R.id.emptyText);
        employeeViewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);
        employeeViewModel.init();
        getEmployeeList();
    }

    //should probably be in the viewmodel.
    private void getEmployeeList () {
        employeeViewModel.getEmployeeRepository().observe(this, EmployeeResponse -> {
            if(EmployeeResponse.getErrorHandler() != null){
                Toast.makeText(this, EmployeeResponse.getErrorHandler().getMessage(), Toast.LENGTH_SHORT).show();
            } else {
                List<Employees> employeeData = EmployeeResponse.getEmployees();
                if (!employeeViewModel.isEmployeeListEmpty(employeeData)) {
                    setupRecyclerView();
                    employeeViewModel.updateAdapter(employeeData);
                } else {
                    emptyTextView.setVisibility(View.VISIBLE);
                }
            }
            simpleProgressBar.setVisibility(View.GONE);
        });
    }


    private void setupRecyclerView() {
        emptyTextView.setVisibility(View.GONE);
        epRecycler.setAdapter(employeeViewModel.getEmployeeAdapter());
    }
}