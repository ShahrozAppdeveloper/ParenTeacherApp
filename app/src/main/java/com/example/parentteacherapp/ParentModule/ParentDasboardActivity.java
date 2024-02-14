package com.example.parentteacherapp.ParentModule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.parentteacherapp.Activity.SignInActivity;
import com.example.parentteacherapp.Activity.SignupAppActivity;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.BookedTeacherParentFragment;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.ChatwithTeacherFragment;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.HomeFragment;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.ListOFTeacherParentFragment;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.UpdateParentProfileFragment;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.ViewAbsentNotificationFragment;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.ViewEventParentFragment;
import com.example.parentteacherapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;


public class ParentDasboardActivity extends AppCompatActivity {
    ActionBar actionBar;
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_dasboard);
        navigationView = findViewById(R.id.bottomNavigationView);
        HomeFragment fragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment, "");
        fragmentTransaction.commit();
        navigationView.setOnNavigationItemSelectedListener(selectedListener);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            int menuid=menuItem.getItemId();
            if (menuid==R.id.homeparentID){
                HomeFragment fragment = new HomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content, fragment, "");
                fragmentTransaction.commit();
            }else if(menuid==R.id.calparentID){
                ViewEventParentFragment fragment = new  ViewEventParentFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content, fragment, "");
                fragmentTransaction.commit();
            }else if(menuid==R.id.chatparentID){
                ChatwithTeacherFragment fragment = new ChatwithTeacherFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content, fragment, "");
                fragmentTransaction.commit();
            }else if(menuid==R.id.updateparentID){
            UpdateParentProfileFragment fragment = new UpdateParentProfileFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.content, fragment, "");
            fragmentTransaction.commit();
        }
            return false;
        }
    };
}


