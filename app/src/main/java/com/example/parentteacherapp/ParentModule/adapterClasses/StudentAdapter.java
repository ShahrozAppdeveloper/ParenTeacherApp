package com.example.parentteacherapp.ParentModule.adapterClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.parentteacherapp.ModelCLass.AddParentDetailToRealtym;
import com.example.parentteacherapp.R;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder>{
    private ArrayList<AddParentDetailToRealtym> list;
    private Context context;

    public StudentAdapter(ArrayList<AddParentDetailToRealtym> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_layout,parent,false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        final AddParentDetailToRealtym data = list.get(position);

    //    Glide.with(context).load(data.getImageurl()).placeholder(R.drawable.man).into(holder.studentImg);

        holder.studentName.setText(data.getName());
        holder.studentRollNumber.setText(data.getRollnum());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder{
        ImageView studentImg;
        TextView studentName, studentRollNumber;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            studentImg = itemView.findViewById(R.id.studentImage);
            studentName = itemView.findViewById(R.id.studentNameText);
            studentRollNumber = itemView.findViewById(R.id.studentRollNumberText);

        }
    }
}
