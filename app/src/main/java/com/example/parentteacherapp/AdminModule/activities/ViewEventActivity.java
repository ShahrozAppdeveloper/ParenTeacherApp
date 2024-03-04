package com.example.parentteacherapp.AdminModule.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.parentteacherapp.R;
import com.example.parentteacherapp.databinding.ActivityViewEventBinding;

public class ViewEventActivity extends AppCompatActivity {
    private ActivityViewEventBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewEventBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}