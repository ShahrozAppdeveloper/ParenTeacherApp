package com.example.parentteacherapp.ParentModule.adapterClasses;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.parentteacherapp.ParentModule.ParentModuleFragment.viewPagerFragments.AllStudentsFragment;
import com.example.parentteacherapp.ParentModule.ParentModuleFragment.viewPagerFragments.EnrolledStudentFragment;

public class StudentViewPagerAdapter extends FragmentPagerAdapter {
    public StudentViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
            fragment = new AllStudentsFragment();
        else if (position == 1)
            fragment = new EnrolledStudentFragment();

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        String title = null;
        if (position == 0)
            title = "All Students";
        else if (position == 1)
            title = "Enrolled Students";
        return title;
    }
}
