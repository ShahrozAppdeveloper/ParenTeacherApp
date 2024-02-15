package com.example.parentteacherapp.ParentModule.ParentModuleFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parentteacherapp.R;
import com.example.parentteacherapp.databinding.FragmentHomeBinding;
import com.example.parentteacherapp.databinding.FragmentViewEventParentBinding;


public class ViewEventParentFragment extends Fragment {

    private FragmentViewEventParentBinding binding;
    public ViewEventParentFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentViewEventParentBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }
}