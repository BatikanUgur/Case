package com.example.newchallenge;

import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newchallenge.Models.Doctor;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DoctorsAdapter extends RecyclerView.Adapter<DoctorsAdapter.DoctorViewHolder> {

    private int rowLayout;
    private Context context;
    private List<Doctor> doctorList;


    public static class DoctorViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout doctorLayout;
        TextView doctorName;
        ImageView image;

        public DoctorViewHolder(View v) {

            super(v);
            doctorLayout = (ConstraintLayout) v.findViewById(R.id.doctors_layout);
            doctorName = (TextView) v.findViewById(R.id.doctorsName);
            image = (ImageView) v.findViewById(R.id.imageDoctors);
        }
    }

    public DoctorsAdapter (List<Doctor> doctorList,int rowLayout,Context context ){

        this.doctorList=doctorList;
        this.rowLayout=rowLayout;
        this.context=context;
        


    }
    @Override
    public DoctorsAdapter.DoctorViewHolder onCreateViewHolder (ViewGroup parent, int viewType){

        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout,parent,false);
        return new DoctorViewHolder(view);
    }



    @Override
    public void onBindViewHolder (DoctorViewHolder holder, final int position) {


        holder.doctorName.setText(doctorList.get(position).getFullName());
        Picasso.with(context).load(doctorList.get(position).getImage().getUrl()).into(holder.image);
        // Picasso.with(context).load(doctor.getImage()).into(holder.image);
                //load(doctor.getImage()).into(holder.image);

    }
    @Override
    public int getItemCount(){
        return doctorList.size();
    }

}
