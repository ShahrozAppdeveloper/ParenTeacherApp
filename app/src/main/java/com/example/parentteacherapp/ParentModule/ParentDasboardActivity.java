package com.example.parentteacherapp.ParentModule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.parentteacherapp.Activity.SignInActivity;
import com.example.parentteacherapp.Activity.SignupAppActivity;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.BookedTeacherParentFragment;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.ChatwithTeacherFragment;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.ListOFTeacherParentFragment;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.UpdateParentProfileFragment;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.ViewAbsentNotificationFragment;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.ViewEventParentFragment;
import com.example.parentteacherapp.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;


public class ParentDasboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_dasboard);
        
    }


}