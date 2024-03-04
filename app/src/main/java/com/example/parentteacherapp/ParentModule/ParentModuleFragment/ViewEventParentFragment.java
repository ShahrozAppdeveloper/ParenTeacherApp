package com.example.parentteacherapp.ParentModule.ParentModuleFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.parentteacherapp.R;
import com.example.parentteacherapp.databinding.FragmentViewEventParentBinding;

import java.util.Calendar;

public class ViewEventParentFragment extends Fragment {
    private FragmentViewEventParentBinding binding;

    public ViewEventParentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentViewEventParentBinding.inflate(inflater, container, false);


        binding.pickDateED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        binding.pickTimeED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });

        return binding.getRoot();
    }

    private void showTimePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // Create a TimePickerDialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                requireContext(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String amPm;
                        if (hourOfDay < 12) {
                            amPm = "AM";
                        } else {
                            amPm = "PM";
                            hourOfDay -= 12;
                        }

                        // Adjust hour for 12-hour format
                        if (hourOfDay == 0) {
                            hourOfDay = 12;
                        }

                        // Format the time and update the EditText
                        String time = String.format("%02d:%02d %s", hourOfDay, minute, amPm);
                        binding.pickTimeED.setText(time);
                    }
                },
                hour, minute, false); // false for 12-hour format, true for 24-hour format

        // Show the TimePickerDialog
        timePickerDialog.show();
    }

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                requireContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Update the EditText with the selected date
                        binding.pickDateED.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                },
                year, month, day);

        datePickerDialog.show();
    }
}