package com.example.parentteacherapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.parentteacherapp.Admin.AdminActivity;
import com.example.parentteacherapp.ParentModule.ParentCreateProfileActivity;
import com.example.parentteacherapp.TeacherModule.CreateTeacherProfileActivity;

public class DashboardActivity extends AppCompatActivity {
    String GetcurrentStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    protected void onStart() {
        super.onStart();
        GetcurrentStatus = getIntent().getExtras().getString("Status");
        if (GetcurrentStatus.equals("Parent")){
            startActivity(new Intent(getApplicationContext(), ParentCreateProfileActivity.class));
        }
        if (GetcurrentStatus.equals("Teacher")){
            startActivity(new Intent(getApplicationContext(), CreateTeacherProfileActivity.class));
        }
        if (GetcurrentStatus.equals("Admin")){
            startActivity(new Intent(getApplicationContext(), AdminActivity.class));
        }

    }
}