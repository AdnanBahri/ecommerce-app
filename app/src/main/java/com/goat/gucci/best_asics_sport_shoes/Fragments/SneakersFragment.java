package com.goat.gucci.best_asics_sport_shoes.Fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.goat.gucci.best_asics_sport_shoes.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SneakersFragment extends Fragment implements View.OnClickListener {

    private TextView tv_onitsuka;
    private TextView tv_asics;

    private ImageView image_onitsuka;
    private ImageView image_asics;


    public SneakersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sneakers, container, false);

        tv_asics = (TextView) view.findViewById(R.id.sneakers_asics_title);
        tv_onitsuka = (TextView) view.findViewById(R.id.sneakers_onitsuka_title);

        image_asics = (ImageView) view.findViewById(R.id.sneakers_asics_image);
        image_onitsuka = (ImageView) view.findViewById(R.id.sneakers_onitsuka_image);

        image_asics.setOnClickListener(this);
        image_onitsuka.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == image_asics)
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Bahri+Studio")));
        else if (v == image_onitsuka)
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Bahri+Studio")));
    }
}
