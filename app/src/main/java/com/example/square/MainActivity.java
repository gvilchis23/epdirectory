package com.example.square;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.feature_empdirectory.activity.DirectoryActivity;

/**
 * Created by memoPilgrim on 04/17/21.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        redirect();
    }

    private void redirect() {
        Intent intent = new Intent(this, DirectoryActivity.class);
        startActivity(intent);
    }
}