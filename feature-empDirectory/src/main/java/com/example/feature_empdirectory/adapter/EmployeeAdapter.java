package com.example.feature_empdirectory.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.feature_empdirectory.R;
import com.example.feature_empdirectory.glidemodule.GlideApp;
import com.example.repository.model.Employees;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by memoPilgrim on 04/17/21.
 */
public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    Context context;
    List<Employees> employees;

    public EmployeeAdapter() {
        employees = new ArrayList<>();
    }

    @NonNull
    @Override
    public EmployeeAdapter.EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.employee_item, parent, false);
        return new  EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeAdapter.EmployeeViewHolder holder, int position) {
        holder.epName.setText(employees.get(position).getFullName());
        holder.epEmail.setText(employees.get(position).getTeam());
        GlideApp.with(context).load(employees.get(position).getPhotoUrlLarge())
                 .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                 .into(holder.epImage);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.context = recyclerView.getContext();
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public void update(final List<Employees> employeeData) {
        //having a bug of the recycler view state after rotating, didnt have enough time for a better solution, so i added clear().
        employees.clear();
        employees.addAll(employeeData);
        notifyDataSetChanged();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder{

        TextView epName;
        TextView epEmail;
        ImageView epImage;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            epName = itemView.findViewById(R.id.epName);
            epEmail = itemView.findViewById(R.id.epEmail);
            epImage = itemView.findViewById(R.id.epImage);
        }
    }
}
