package com.example.parentteacherapp.ParentModule.ParentModuleFragment.viewPagerFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parentteacherapp.ModelCLass.AddParentDetailToRealtym;
import com.example.parentteacherapp.ModelCLass.AddTeacherDetailToRealtym;
import com.example.parentteacherapp.ParentModule.adapterClasses.StudentAdapter;
import com.example.parentteacherapp.R;
import com.example.parentteacherapp.databinding.FragmentAllStudentsBinding;

import java.util.ArrayList;

public class AllStudentsFragment extends Fragment {
    private FragmentAllStudentsBinding binding;
    private ArrayList<AddParentDetailToRealtym> list;
    private StudentAdapter adapter;
    public AllStudentsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAllStudentsBinding.inflate(inflater,container,false);

        list = new ArrayList<>();

        list.add(new AddParentDetailToRealtym("123","Shahroz","12345","Computer Science","ww."));
        list.add(new AddParentDetailToRealtym("123","Shahroz","12345","Computer Science","ww."));
        list.add(new AddParentDetailToRealtym("123","Shahroz","12345","Computer Science","ww."));
        list.add(new AddParentDetailToRealtym("123","Shahroz","12345","Computer Science","ww."));
        list.add(new AddParentDetailToRealtym("123","Shahroz","12345","Computer Science","ww."));
        list.add(new AddParentDetailToRealtym("123","Shahroz","12345","Computer Science","ww."));
        list.add(new AddParentDetailToRealtym("123","Shahroz","12345","Computer Science","ww."));
        list.add(new AddParentDetailToRealtym("123","Shahroz","12345","Computer Science","ww."));
        list.add(new AddParentDetailToRealtym("123","Shahroz","12345","Computer Science","ww."));
        list.add(new AddParentDetailToRealtym("123","Shahroz","12345","Computer Science","ww."));

        adapter = new StudentAdapter(list,getContext());

        binding.allStudentRecView.setAdapter(adapter);
        binding.allStudentRecView.setLayoutManager(new GridLayoutManager(requireContext(),2));

        return binding.getRoot();
    }
}