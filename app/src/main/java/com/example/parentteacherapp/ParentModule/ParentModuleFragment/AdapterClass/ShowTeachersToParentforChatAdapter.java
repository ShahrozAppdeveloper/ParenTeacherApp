package com.example.parentteacherapp.ParentModule.ParentModuleFragment.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parentteacherapp.ParentModule.ParentModuleFragment.AdapterClass.ModelClass.ShowTeacherDetails;
import com.example.parentteacherapp.R;

import java.util.ArrayList;

public class ShowTeachersToParentforChatAdapter extends RecyclerView.Adapter<ShowTeachersToParentforChatAdapter.Viewholder> {
    ArrayList<ShowTeacherDetails> datalist;
    Context context;

    public ShowTeachersToParentforChatAdapter(ArrayList<ShowTeacherDetails> datalist, Context context) {
        this.datalist = datalist;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);

        // Inflate the layout

        View photoView
                = inflater
                .inflate(R.layout.rvshowteacherforchat,
                        parent, false);

       return  new Viewholder(photoView);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        final  ShowTeacherDetails temp = datalist.get(position);


    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        public Viewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
