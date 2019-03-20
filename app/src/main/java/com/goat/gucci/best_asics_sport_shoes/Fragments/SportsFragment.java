package com.goat.gucci.best_asics_sport_shoes.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
import com.goat.gucci.best_asics_sport_shoes.Activities.WebViewActivity;
import com.goat.gucci.best_asics_sport_shoes.Adapters.SmallViewHolder;
import com.goat.gucci.best_asics_sport_shoes.Models.BasicModel;
import com.goat.gucci.best_asics_sport_shoes.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class SportsFragment extends Fragment {

    private Context context;
    private RecyclerView recycler;
    private DatabaseReference reference;
    private FirebaseRecyclerOptions<BasicModel> options;
    private FirebaseRecyclerAdapter<BasicModel, SportHolder> adapter;


    public SportsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sports, container, false);

        context = getContext();

        setUpRecyclerAdapter();

        recycler = (RecyclerView) view.findViewById(R.id.sport_recycler);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(context));

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

        reference = FirebaseDatabase.getInstance().getReference("Sport Home");

        options = new FirebaseRecyclerOptions.Builder<BasicModel>()
                .setQuery(reference,BasicModel.class)
                .build();

        adapter = new FirebaseRecyclerAdapter<BasicModel, SportHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull SportHolder holder, int position, @NonNull BasicModel model) {
                holder.setOnBindViewHolder(model);
            }

            @NonNull
            @Override
            public SportHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(context).inflate(R.layout.sports_layout,parent,false);
                return new SportHolder(context,view);
            }
        };

    }

    private class SportHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private ImageView image;
        private View view;

        public SportHolder(Context context, View itemView) {
            super(itemView);
            view = itemView;
        }

        public void setOnBindViewHolder(final BasicModel model){

            title = (TextView) view.findViewById(R.id.sport_title);
            image = (ImageView) view.findViewById(R.id.sport_image);

            title.setText(model.getTitle());
            Picasso.get().load(model.getUrl()).into(image);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!model.getTitle().equals("TENNIS"))
                        startActivity(new Intent(context, SportsSneakerContentActivity.class)
                                .putExtra("from",model.getTitle()));
                    else
                        startActivity(new Intent(context, WebViewActivity.class)
                                .putExtra("url",model.getUrlWeb()));
                }
            });
        }
    }

}
