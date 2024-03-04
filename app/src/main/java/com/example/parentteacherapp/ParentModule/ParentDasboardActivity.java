package com.example.parentteacherapp.ParentModule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;


import com.example.parentteacherapp.Activity.SignInActivity;
import com.example.parentteacherapp.Activity.SignupAppActivity;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.AttendenceFragment;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.BookedTeacherParentFragment;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.ChatwithTeacherFragment;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.ListOFTeacherParentFragment;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.StudentListFragment;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.UpdateParentProfileFragment;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.UpdateProfileFragment;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.ViewAbsentNotificationFragment;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.ViewEventParentFragment;
import com.example.parentteacherapp.R;
import com.example.parentteacherapp.databinding.ActivityParentDasboardBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;


public class ParentDasboardActivity extends AppCompatActivity {
    private ActivityParentDasboardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityParentDasboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(getResources().getColor(R.color.green_color));

        ChangeFragment(new ViewEventParentFragment());

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int menuId = item.getItemId();
                if (menuId == R.id.teacher_events) {
                    ChangeFragment(new ViewEventParentFragment());
                } else if (menuId == R.id.teacher_studentList) {
                    ChangeFragment(new StudentListFragment());
                } else if (menuId == R.id.teacher_assignment) {
                    ChangeFragment(new AttendenceFragment());
                } else if (menuId == R.id.teacher_updateProfile) {
                    ChangeFragment(new UpdateProfileFragment());
                } else {

                }
                return true;
            }
        });

        
    }

    public void ChangeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrames,fragment).commit();
    }
}