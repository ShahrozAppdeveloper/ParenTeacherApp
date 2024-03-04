package com.example.parentteacherapp.ParentModule.ParentModuleFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parentteacherapp.R;
import com.example.parentteacherapp.databinding.FragmentUpdateProfileBinding;

public class UpdateProfileFragment extends Fragment {
    private FragmentUpdateProfileBinding binding;
    public UpdateProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUpdateProfileBinding.inflate(inflater,container,false);



        return binding.getRoot();
    }
}