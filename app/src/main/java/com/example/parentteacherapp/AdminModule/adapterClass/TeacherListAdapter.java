package com.example.parentteacherapp.AdminModule.adapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.parentteacherapp.ModelCLass.AddTeacherDetailToRealtym;
import com.example.parentteacherapp.R;

import java.util.ArrayList;

public class TeacherListAdapter extends RecyclerView.Adapter<TeacherListAdapter.TeacherListViewHolder>{
    private ArrayList<AddTeacherDetailToRealtym> list;
    private Context context;

    public TeacherListAdapter(ArrayList<AddTeacherDetailToRealtym> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public TeacherListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_parent_list,parent,false);
        return new TeacherListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherListViewHolder holder, int position) {
        final AddTeacherDetailToRealtym data = list.get(position);

//        Glide.with(context).load(data.getImageurl()).placeholder(R.drawable.person).into(holder.teacherImg);

        holder.teacherImg.setImageResource(R.drawable.man);

        holder.teacherName.setText(data.getName());
        holder.teacherRollNo.setText(data.getSchoolid());
        holder.teacherDepartment.setText(data.getDepartment());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TeacherListViewHolder extends RecyclerView.ViewHolder{
        ImageView teacherImg;
        TextView teacherName, teacherRollNo, teacherDepartment;
        public TeacherListViewHolder(@NonNull View itemView) {
            super(itemView);

            teacherImg = itemView.findViewById(R.id.admin_parentImg);
            teacherName = itemView.findViewById(R.id.admin_parentName);
            teacherRollNo = itemView.findViewById(R.id.admin_parentRollNo);
            teacherDepartment = itemView.findViewById(R.id.admin_parentDepartment);
        }
    }
}
