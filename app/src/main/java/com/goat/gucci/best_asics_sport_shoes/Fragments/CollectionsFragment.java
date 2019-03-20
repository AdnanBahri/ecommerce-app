package com.goat.gucci.best_asics_sport_shoes.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.goat.gucci.best_asics_sport_shoes.Activities.SportsSneakerContentActivity;
import com.goat.gucci.best_asics_sport_shoes.Models.CollectionsModel;
import com.goat.gucci.best_asics_sport_shoes.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectionsFragment extends Fragment {

    private RecyclerView recycler;
    private DatabaseReference reference;
    private FirebaseRecyclerOptions<CollectionsModel> options;
    private FirebaseRecyclerAdapter<CollectionsModel,ViewHolder> adapter;

    private Context context;


    public CollectionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_collections, container, false);

        context = getContext();

        recycler = (RecyclerView) view.findViewById(R.id.collections_recyler);
        recycler.setLayoutManager(new LinearLayoutManager(context));
        populateRecycler();
        recycler.setAdapter(adapter);

        return view;
    }

    private void populateRecycler() {

        reference = FirebaseDatabase.getInstance().getReference("Asics").child("Collections");
        options = new FirebaseRecyclerOptions.Builder<CollectionsModel>()
                .setQuery(reference,CollectionsModel.class)
                .build();

        adapter = new FirebaseRecyclerAdapter<CollectionsModel, ViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull CollectionsModel model) {
                holder.setOnBindViewHolder(model);
            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view  = LayoutInflater.from(context).inflate(R.layout.collections_card,parent,false);
                return new ViewHolder(view);
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        if (adapter != null)
            adapter.startListening();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter != null)
            adapter.startListening();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (adapter != null)
            adapter.stopListening();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView image;
        private View card;

        public ViewHolder(View itemView) {
            super(itemView);
            card = itemView;

        }

        public void setOnBindViewHolder(final CollectionsModel model){
            title = (TextView) card.findViewById(R.id.collection_title);
            image = (ImageView) card.findViewById(R.id.collection_img);

            title.setText(model.getTitle());
            Picasso.get().load(model.getImg()).into(image);

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   startActivity(new Intent(context, SportsSneakerContentActivity.class)
                                                        .putExtra("from",model.getTitle()));
                }
            });
        }
    }
}
