package com.example.parentteacherapp.AdminModule.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.example.parentteacherapp.AdminModule.adapterClass.TeacherListAdapter;
import com.example.parentteacherapp.ModelCLass.AddTeacherDetailToRealtym;
import com.example.parentteacherapp.R;
import com.example.parentteacherapp.databinding.ActivityListOfTeachersBinding;

import java.util.ArrayList;

public class ListOfTeachersActivity extends AppCompatActivity {
    private ActivityListOfTeachersBinding binding;
    private ArrayList<AddTeacherDetailToRealtym> list;
    private TeacherListAdapter adapter;
    private String imageUrl = "https://drive.google.com/file/d/1Ih2-g2_6Hx-P7jPfIYH-EMSE3LNesqDS/view?usp=drive_link";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListOfTeachersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        list.add(new AddTeacherDetailToRealtym("userId","Shahroz","1","BSCS",imageUrl));
        list.add(new AddTeacherDetailToRealtym("userId","Ameeq","2","BSCS",imageUrl));
        list.add(new AddTeacherDetailToRealtym("userId","Suffian","3","BSCS",imageUrl));
        list.add(new AddTeacherDetailToRealtym("userId","Abdullah","4","BSCS",imageUrl));
        list.add(new AddTeacherDetailToRealtym("userId","Ahmad","5","BSCS",imageUrl));
        list.add(new AddTeacherDetailToRealtym("userId","Umar","6","BSCS",imageUrl));
        list.add(new AddTeacherDetailToRealtym("userId","Raibal","7","BSCS",imageUrl));
        list.add(new AddTeacherDetailToRealtym("userId","Ehsan","8","BSCS",imageUrl));
        list.add(new AddTeacherDetailToRealtym("userId","Sidra","9","BSCS",imageUrl));
        list.add(new AddTeacherDetailToRealtym("userId","Sidduqe","10","BSCS",imageUrl));

        adapter = new TeacherListAdapter(list, this);

        binding.listOfTeacherRecView.setAdapter(adapter);
        binding.listOfTeacherRecView.setLayoutManager(new GridLayoutManager(this,2));

    }
}