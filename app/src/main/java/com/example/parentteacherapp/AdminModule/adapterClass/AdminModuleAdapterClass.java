package com.example.parentteacherapp.AdminModule.adapterClass;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parentteacherapp.AdminModule.activities.ListOfStudentsActivity;
import com.example.parentteacherapp.AdminModule.activities.ListOfTeachersActivity;
import com.example.parentteacherapp.AdminModule.activities.ViewEventActivity;
import com.example.parentteacherapp.AdminModule.modelClass.AdminModuleModelClass;
import com.example.parentteacherapp.R;

import java.util.ArrayList;

public class AdminModuleAdapterClass extends RecyclerView.Adapter<AdminModuleAdapterClass.AdminModuleViewHolder> {
    private ArrayList<AdminModuleModelClass> list;
    private Context context;

    public AdminModuleAdapterClass(ArrayList<AdminModuleModelClass> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public AdminModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_items,parent,false);
        return new AdminModuleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminModuleViewHolder holder, int position) {
        final AdminModuleModelClass data = list.get(position);

        holder.textView.setText(data.getTitle());
        holder.imageView.setImageResource(data.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.getPosition() == 1){
                    context.startActivity(new Intent(context, ListOfTeachersActivity.class));
                } else if (data.getPosition() == 2) {
                    context.startActivity(new Intent(context, ViewEventActivity.class));
                } else if (data.getPosition() == 3) {
                    context.startActivity(new Intent(context, ListOfStudentsActivity.class));
                } else {
                    Toast.makeText(context, "Invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class AdminModuleViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public AdminModuleViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.adminModuleItemImage);
            textView = itemView.findViewById(R.id.adminModuleItemText);
        }
    }
}
