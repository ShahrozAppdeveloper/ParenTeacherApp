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
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_dasboard);
        LoadHomeFragmentData();
        Navdrawer();
    }
    private void LoadHomeFragmentData(){
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.framelayoutid,new UpdateParentProfileFragment())
                .commit();
    }
    private void Navdrawer(){
        NavigationView navigationView;
        DrawerLayout drawerLayout;
        Toolbar toolbar=findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);
        navigationView=findViewById(R.id.nav_viewid);
        drawerLayout=findViewById(R.id.drawerlayoutid);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.updateuserpro) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.framelayoutid, new UpdateParentProfileFragment())
                            .commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (item.getItemId() == R.id.lisTofTeacher) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.framelayoutid, new ListOFTeacherParentFragment())
                            .commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (item.getItemId() == R.id.TeachersID) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.framelayoutid, new BookedTeacherParentFragment())
                            .commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (item.getItemId() == R.id.viewEventsmenuID) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.framelayoutid, new ViewEventParentFragment())
                            .commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (item.getItemId() == R.id.viewAbsentNotificationmenuID) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.framelayoutid, new ViewAbsentNotificationFragment())
                            .commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (item.getItemId() == R.id.chatwithTeachers) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.framelayoutid, new ChatwithTeacherFragment())
                            .commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (item.getItemId() == R.id.signout) {
                    FirebaseAuth.getInstance().signOut();
                    Toast.makeText(ParentDasboardActivity.this, "Signout", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(ParentDasboardActivity.this, SignInActivity.class);
                    startActivity(i);
                }

                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}