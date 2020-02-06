package com.example.newchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.newchallenge.Models.Repo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    RestInterface restInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.doctors_recycler_view);
        recyclerView.setLayoutManager((new LinearLayoutManager(this)));





        restInterface=ApiClient.getClient().create(RestInterface.class);

        Call<Repo> call=restInterface.getDoctors();

        call.enqueue(new Callback<Repo>() {
            @Override
            public void onResponse(Call<Repo> call, Response<Repo> response) {

                DoctorsAdapter doctorsAdapter = new DoctorsAdapter(response.body().getDoctors(),R.layout.list_item_doctors,getApplicationContext());
                recyclerView.setAdapter(doctorsAdapter);
                Repo repoList= null;
                repoList=response.body();
                response.body().getDoctors();
                    for(int i=0;i<repoList.getDoctors().size();i++){
                        System.out.println(""+repoList.getDoctors().get(i).getFullName()+"\n");
                        System.out.println(""+repoList.getDoctors().get(i).getGender()+"\n");
                        System.out.println(""+repoList.getDoctors().get(i).getUserStatus()+"\n");
                    }

                }

            @Override
            public void onFailure(Call<Repo> call, Throwable t) {

                t.getMessage();
            }
        });


    }
}
