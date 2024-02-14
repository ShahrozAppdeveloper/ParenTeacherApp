package com.example.parentteacherapp.ParentModule.ParentModuleFragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.example.parentteacherapp.ParentModule.ParentModuleFragment.AdapterClass.AssignmentAdapter;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.AdapterClass.ModelClass.AssignmentModelCass;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.AdapterClass.ModelClass.ShowTeacherDetails;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.AdapterClass.TeachersToParentAdapter;
import com.example.parentteacherapp.R;
import com.example.parentteacherapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    ArrayList<AssignmentModelCass> datalist;
    ArrayList<ShowTeacherDetails> list;
    AssignmentAdapter assignmentAdapter;
    TeachersToParentAdapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        ShowAssignment();
        ShowTeacherlist();
        changeColorStatusBar(R.color.green_color,this);
        return binding.getRoot();

    }
    private void ShowAssignment(){
        datalist = new ArrayList<>();
        datalist.add(new AssignmentModelCass("","",R.drawable.usericon));
        datalist.add(new AssignmentModelCass("","",R.drawable.usericon));
        datalist.add(new AssignmentModelCass("","",R.drawable.usericon));
        assignmentAdapter = new AssignmentAdapter(datalist,getContext());
        binding.coursedetailrv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.coursedetailrv.setAdapter(assignmentAdapter);

    }
    private void ShowTeacherlist(){
        list = new ArrayList<>();
        list.add(new ShowTeacherDetails("","","","",""));
        list.add(new ShowTeacherDetails("","","","",""));
        list.add(new ShowTeacherDetails("","","","",""));
        list.add(new ShowTeacherDetails("","","","",""));

        adapter = new TeachersToParentAdapter(list,getContext());
        binding.rvteacherlistID.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.rvteacherlistID.setAdapter(adapter);
    }
    public void changeColorStatusBar(@ColorRes int color, Fragment fragment) {
        // Ensure the fragment is attached to an activity
        if (fragment.getActivity() != null) {
            Window window = fragment.getActivity().getWindow();
            View decorView = window.getDecorView();
            WindowInsetsControllerCompat wic = new WindowInsetsControllerCompat(window, decorView);
            wic.setAppearanceLightStatusBars(true);
            // You can set any background color to the status bar.
            window.setStatusBarColor(ContextCompat.getColor(fragment.requireContext(), color));
        }
    }

}