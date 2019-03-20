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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.goat.gucci.best_asics_sport_shoes.Activities.CategorieContentActivity;
import com.goat.gucci.best_asics_sport_shoes.Models.CustomModel;
import com.goat.gucci.best_asics_sport_shoes.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends Fragment {

    private FirebaseDatabase database;
    private DatabaseReference reference;

    private FirebaseRecyclerOptions<CustomModel> options;
    private FirebaseRecyclerAdapter<CustomModel,ViewHolder> adapter;

    private RecyclerView recycler;


    public CategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        FirebaseApp.initializeApp(getContext());
        populateRecycler();

        recycler = (RecyclerView) view.findViewById(R.id.home_categorie_recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(adapter);

        return view;
    }

    private void populateRecycler() {
        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("Asics").child("Categories");

        options = new FirebaseRecyclerOptions.Builder<CustomModel>()
                .setQuery(reference,CustomModel.class)
                .build();

        adapter = new FirebaseRecyclerAdapter<CustomModel, ViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull CustomModel model) {
                holder.onBindViewHolder(model);
            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(getContext()).inflate(R.layout.home_categorie_layout,parent,false);
                return new ViewHolder(view,getContext());
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

    private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tv_title;
        private ImageView header;
        private ImageView rightImage;
        private ImageView leftImage;
        private TextView rightTitle;
        private TextView leftTitle;
        private Button viewAll;

        private View left;
        private View right;

        private View view;
        private Context context;

        public ViewHolder(View itemView, Context context) {
            super(itemView);

            view = itemView;
            this.context = context;

            header = (ImageView) view.findViewById(R.id.home_categorie_header);
            rightImage = (ImageView) view.findViewById(R.id.home_right_image);
            leftImage = (ImageView) view.findViewById(R.id.home_left_image);

            rightTitle = (TextView) view.findViewById(R.id.home_right_title);
            leftTitle = (TextView) view.findViewById(R.id.home_left_title);
            tv_title = (TextView) view.findViewById(R.id.home_categorie_title);

            viewAll = (Button) view.findViewById(R.id.home_categorie_view_all);

            right = (LinearLayout) view.findViewById(R.id.right);
            left = (LinearLayout) view.findViewById(R.id.left);
        }

        public void onBindViewHolder(final CustomModel model){

            Picasso.get().load(model.getHeader()).into(header);
            Picasso.get().load(model.getLeftUrl()).into(leftImage);
            Picasso.get().load(model.getRightUrl()).into(rightImage);

            tv_title.setText(model.getTitle());
            leftTitle.setText(model.getLeftTitle());
            rightTitle.setText(model.getRightTitle());

            viewAll.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            startActivity(new Intent(context, CategorieContentActivity.class)
                .putExtra("from",tv_title.getText()));
        }
    }

}
