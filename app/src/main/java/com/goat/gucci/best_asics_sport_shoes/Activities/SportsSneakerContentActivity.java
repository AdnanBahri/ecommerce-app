package com.goat.gucci.best_asics_sport_shoes.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.goat.gucci.best_asics_sport_shoes.Adapters.SmallViewHolder;
import com.goat.gucci.best_asics_sport_shoes.Models.BasicModel;
import com.goat.gucci.best_asics_sport_shoes.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SportsSneakerContentActivity extends AppCompatActivity {

    private String from;
    private DatabaseReference ref;
    private FirebaseRecyclerOptions<BasicModel> options;
    private FirebaseRecyclerAdapter<BasicModel, SmallViewHolder> adapter;

    private RecyclerView recycler;
    private Context context;

    private static String intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_sneaker_content);

        context = getApplicationContext();
        from = getIntent().getStringExtra("from");
        recycler = (RecyclerView) findViewById(R.id.sneakers_content);

        switchIntent();
        setupAdapter();

        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new GridLayoutManager(context,2));


    }

    @Override
    protected void onStart() {
        super.onStart();
        if (adapter != null)
            adapter.startListening();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (adapter != null)
            adapter.stopListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adapter != null)
            adapter.startListening();
    }

    private void switchIntent(){
        switch (from){
            case "FITNESS":
                ref = FirebaseDatabase.getInstance().getReference("Sport").child("FITNESS");
                intent = "Sports";
                break;
            case "PADEL GEAR":
                ref = FirebaseDatabase.getInstance().getReference("Sport").child("PADEL");
                intent = "Sports";
                break;
            case "RUNNING GEAR":
                ref = FirebaseDatabase.getInstance().getReference("Sport").child("RUNNING");
                intent = "Sports";
                break;
            case "TRAIL RUNNING":
                ref = FirebaseDatabase.getInstance().getReference("Sport").child("TRAIL");
                intent = "Sports";
                break;
            case "VOLLEYBALL GEAR":
                ref = FirebaseDatabase.getInstance().getReference("Collections").child("VOLLEYBALL");
                intent = "Sports";
                break;
            case "ASICS SPECIALS":
                ref = FirebaseDatabase.getInstance().getReference("Collections").child("ASICS SPECIALS");
                intent = "Collections";
                break;
            case "DYNAFLYTE 3":
                ref = FirebaseDatabase.getInstance().getReference("Collections").child("DYNAFLYTE 3");
                intent = "Collections";
                break;
            case "GEL CUMULUS 20":
                ref = FirebaseDatabase.getInstance().getReference("Collections").child("GEL CUMULUS 20");
                intent = "Collections";
                break;
            case "GEL KAYANO":
                ref = FirebaseDatabase.getInstance().getReference("Collections").child("GEL KAYANO");
                intent = "Collections";
                break;
            case "GEL NIMBUS":
                ref = FirebaseDatabase.getInstance().getReference("Collections").child("GEL NIMBUS");
                intent = "Collections";
                break;
            case "GEL QUANTUM":
                ref = FirebaseDatabase.getInstance().getReference("Collections").child("GEL QUANTUM");
                intent = "Collections";
                break;
            case "GT SERIES":
                ref = FirebaseDatabase.getInstance().getReference("Collections").child("GT SERIES");
                intent = "Collections";
                break;
            case "METARUN":
                ref = FirebaseDatabase.getInstance().getReference("Sport").child("METARUN");
                intent = "Collections";
                break;
        }
    }

    private void setupAdapter() {

        options = new FirebaseRecyclerOptions.Builder<BasicModel>()
                .setQuery(ref,BasicModel.class)
                .build();

        adapter = new FirebaseRecyclerAdapter<BasicModel, SmallViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull SmallViewHolder holder, int position, @NonNull BasicModel model) {
                holder.setOnBindViewHolder(model);
            }

            @NonNull
            @Override
            public SmallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(context).inflate(R.layout.small_layout,parent,false);
                return new SmallViewHolder(context,view,intent);
            }
        };
    }
}
