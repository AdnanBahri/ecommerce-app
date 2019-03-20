package com.goat.gucci.best_asics_sport_shoes.Fragments.Women;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.goat.gucci.best_asics_sport_shoes.Adapters.SmallViewHolder;
import com.goat.gucci.best_asics_sport_shoes.Models.BasicModel;
import com.goat.gucci.best_asics_sport_shoes.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class WomenClothes extends Fragment {

    private Context context;
    private RecyclerView recycler;
    private DatabaseReference reference;
    private FirebaseRecyclerOptions<BasicModel> options;
    private FirebaseRecyclerAdapter<BasicModel, SmallViewHolder> adapter;


    public WomenClothes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_women_clothes, container, false);

        context = getContext();

        setUpRecyclerAdapter();

        recycler = (RecyclerView) view.findViewById(R.id.women_clothes);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new GridLayoutManager(context,2));

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (adapter != null)
            adapter.startListening();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (adapter != null)
            adapter.startListening();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter != null)
            adapter.startListening();
    }

    private void setUpRecyclerAdapter() {

        reference = FirebaseDatabase.getInstance().getReference("Women").child("Clothes");

        options = new FirebaseRecyclerOptions.Builder<BasicModel>()
                .setQuery(reference,BasicModel.class)
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
                return new SmallViewHolder(context,view,"Women");
            }
        };

    }

}
