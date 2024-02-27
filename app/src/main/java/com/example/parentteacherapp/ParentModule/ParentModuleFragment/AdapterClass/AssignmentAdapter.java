package com.example.parentteacherapp.ParentModule.ParentModuleFragment.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parentteacherapp.ParentModule.ParentModuleFragment.AdapterClass.ModelClass.AssignmentModelCass;
import com.example.parentteacherapp.R;

import java.util.ArrayList;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.Viewholder> {
    ArrayList<AssignmentModelCass> datalist;
    Context context;
    private int[] colors = {R.color.cardfour, R.color.cardtwo, R.color.cardthree, R.color.cardfour};


    public AssignmentAdapter(ArrayList<AssignmentModelCass> datalist, Context context) {
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
                .inflate(R.layout.rvlayoutcousre,
                        parent, false);

       return  new Viewholder(photoView);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        final  AssignmentModelCass temp = datalist.get(position);
        int colorIndex = position % colors.length;
        int color = ContextCompat.getColor(context, colors[colorIndex]);
        holder.cardView.setBackgroundColor(color);
        
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        ConstraintLayout cardView;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.rv_layoutcourseID);
        }
    }
}
