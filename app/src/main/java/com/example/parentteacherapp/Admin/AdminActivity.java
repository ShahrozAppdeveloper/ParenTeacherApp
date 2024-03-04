package com.example.parentteacherapp.Admin;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.parentteacherapp.AdminModule.adapterClass.AdminModuleAdapterClass;
import com.example.parentteacherapp.AdminModule.modelClass.AdminModuleModelClass;
import com.example.parentteacherapp.R;
import com.example.parentteacherapp.databinding.ActivityAdminBinding;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {
    private ActivityAdminBinding binding;
    private ArrayList<AdminModuleModelClass> list;
    private AdminModuleAdapterClass adapterClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        changeColorStatusBar(R.color.green_color);

        binding.adminAnimation.playAnimation();

        list = new ArrayList<>();

        list.add(new AdminModuleModelClass(R.drawable.pt_list_light, "List of Teachers",1));
        list.add(new AdminModuleModelClass(R.drawable.red_carpet,"View Event",2));
        list.add(new AdminModuleModelClass(R.drawable.pt_list_light,"List of Students",3));

        adapterClass = new AdminModuleAdapterClass(list,this);

        binding.adminModuleRecView.setAdapter(adapterClass);
        binding.adminModuleRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

    }

    public void changeColorStatusBar(@ColorRes int color) {
        Window window = getWindow();
        View decorView = window.getDecorView();
        WindowInsetsControllerCompat wic = new WindowInsetsControllerCompat(window, decorView);
        wic.setAppearanceLightStatusBars(true);
        // You can set any background color to the status bar.
        window.setStatusBarColor(ContextCompat.getColor(this, color));
    }
}