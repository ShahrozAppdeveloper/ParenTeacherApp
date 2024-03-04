package com.example.parentteacherapp.ParentModule.ParentModuleFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parentteacherapp.ParentModule.adapterClasses.StudentViewPagerAdapter;
import com.example.parentteacherapp.R;
import com.example.parentteacherapp.databinding.FragmentStudentListBinding;

public class StudentListFragment extends Fragment {
    private FragmentStudentListBinding binding;
    StudentViewPagerAdapter viewPagerAdapter;
    public StudentListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStudentListBinding.inflate(inflater,container,false);

        viewPagerAdapter = new StudentViewPagerAdapter(
                requireActivity().getSupportFragmentManager());
        binding.viewPager.setAdapter(viewPagerAdapter);

        binding.tabLayout.setupWithViewPager(binding.viewPager);

        return binding.getRoot();
    }
}