package com.example.parentteacherapp.Activity;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.parentteacherapp.Admin.AdminActivity;
import com.example.parentteacherapp.ParentModule.ParentCreateProfileActivity;
import com.example.parentteacherapp.R;
import com.example.parentteacherapp.eTeacherModule.CreateTeacherProfileActivity;
import com.google.firebase.auth.FirebaseAuth;

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