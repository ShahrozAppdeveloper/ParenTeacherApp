package com.example.parentteacherapp.AdminModule.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.example.parentteacherapp.AdminModule.adapterClass.ParentListAdapter;
import com.example.parentteacherapp.ModelCLass.AddParentDetailToRealtym;
import com.example.parentteacherapp.ModelCLass.AddTeacherDetailToRealtym;
import com.example.parentteacherapp.R;
import com.example.parentteacherapp.databinding.ActivityListOfStudentsBinding;

import java.util.ArrayList;

public class ListOfStudentsActivity extends AppCompatActivity {
    private ActivityListOfStudentsBinding binding;
    private ArrayList<AddParentDetailToRealtym> list;
    private ParentListAdapter adapter;
    private String imageUrl = "https://drive.google.com/file/d/1Ih2-g2_6Hx-P7jPfIYH-EMSE3LNesqDS/view?usp=drive_link";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListOfStudentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        list.add(new AddParentDetailToRealtym("userId","Shahroz","1","BSCS",imageUrl));
        list.add(new AddParentDetailToRealtym("userId","Ameeq","2","BSCS",imageUrl));
        list.add(new AddParentDetailToRealtym("userId","Suffian","3","BSCS",imageUrl));
        list.add(new AddParentDetailToRealtym("userId","Abdullah","4","BSCS",imageUrl));
        list.add(new AddParentDetailToRealtym("userId","Ahmad","5","BSCS",imageUrl));
        list.add(new AddParentDetailToRealtym("userId","Umar","6","BSCS",imageUrl));
        list.add(new AddParentDetailToRealtym("userId","Raibal","7","BSCS",imageUrl));
        list.add(new AddParentDetailToRealtym("userId","Ehsan","8","BSCS",imageUrl));
        list.add(new AddParentDetailToRealtym("userId","Sidra","9","BSCS",imageUrl));
        list.add(new AddParentDetailToRealtym("userId","Sidduqe","10","BSCS",imageUrl));

        adapter = new ParentListAdapter(list,this);

        binding.listOfStudentRecView.setAdapter(adapter);
        binding.listOfStudentRecView.setLayoutManager(new GridLayoutManager(this,2));

    }
}