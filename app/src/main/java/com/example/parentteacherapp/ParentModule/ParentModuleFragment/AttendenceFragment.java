package com.example.parentteacherapp.ParentModule.ParentModuleFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parentteacherapp.R;
import com.example.parentteacherapp.databinding.FragmentAttendenceBinding;

public class AttendenceFragment extends Fragment {
    private FragmentAttendenceBinding binding;

    public AttendenceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAttendenceBinding.inflate(inflater,container,false);



        return binding.getRoot();
    }
}