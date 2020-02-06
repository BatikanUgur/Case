package com.example.newchallenge.Models;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repo {

        @SerializedName("doctors")
        @Expose
        private List<Doctor> doctors = null;

        public List<Doctor> getDoctors() {
            return doctors;
        }

        public void setDoctors(List<Doctor> doctors) {
            this.doctors = doctors;
        }

    }

