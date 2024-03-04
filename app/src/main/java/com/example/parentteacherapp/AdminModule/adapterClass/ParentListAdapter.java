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
import com.example.parentteacherapp.ModelCLass.AddParentDetailToRealtym;
import com.example.parentteacherapp.R;

import java.util.ArrayList;

public class ParentListAdapter extends RecyclerView.Adapter<ParentListAdapter.ParentListViewHolder>{
    private ArrayList<AddParentDetailToRealtym> list;
    private Context context;

    public ParentListAdapter(ArrayList<AddParentDetailToRealtym> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ParentListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_parent_list,parent,false);
        return new ParentListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentListViewHolder holder, int position) {
        final AddParentDetailToRealtym data = list.get(position);

//        Glide.with(context).load(data.getImageurl()).placeholder(R.drawable.person).into(holder.parentImg);

        holder.parentImg.setImageResource(R.drawable.man);

        holder.parentName.setText(data.getName());
        holder.parentRollNo.setText(data.getRollnum());
        holder.parentDepartment.setText(data.getDepartment());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ParentListViewHolder extends RecyclerView.ViewHolder{
        ImageView parentImg;
        TextView parentName, parentRollNo, parentDepartment;
        public ParentListViewHolder(@NonNull View itemView) {
            super(itemView);

            parentImg = itemView.findViewById(R.id.admin_parentImg);
            parentName = itemView.findViewById(R.id.admin_parentName);
            parentRollNo = itemView.findViewById(R.id.admin_parentRollNo);
            parentDepartment = itemView.findViewById(R.id.admin_parentDepartment);

        }
    }
}
