package com.goat.gucci.best_asics_sport_shoes.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.goat.gucci.best_asics_sport_shoes.Models.BasicModel;
import com.goat.gucci.best_asics_sport_shoes.R;
import com.goat.gucci.best_asics_sport_shoes.WebViews.CollectionWebView;
import com.goat.gucci.best_asics_sport_shoes.WebViews.KidsWebView;
import com.goat.gucci.best_asics_sport_shoes.WebViews.MenWebView;
import com.goat.gucci.best_asics_sport_shoes.WebViews.NewArrivalsWebView;
import com.goat.gucci.best_asics_sport_shoes.WebViews.SportWebView;
import com.goat.gucci.best_asics_sport_shoes.WebViews.WomenWebView;
import com.squareup.picasso.Picasso;

public class SmallViewHolder extends RecyclerView.ViewHolder {

    private ImageView image;
    private TextView textView;

    private CardView card;
    private View view;

    private Context context;
    private String from;


    public SmallViewHolder(Context context, View itemView, String from) {
        super(itemView);

        view = itemView;

        image = (ImageView) itemView.findViewById(R.id.small_image);
        textView = (TextView) itemView.findViewById(R.id.small_title);
        card = (CardView) itemView.findViewById(R.id.small_card);

        this.context = context;
        this.from = from;
    }

    public void setOnBindViewHolder(final BasicModel model){
        textView.setText(model.getTitle());
        Picasso.get().load(model.getUrl()).into(image);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(switchFrom(model));
            }
        });
    }

    private Intent switchFrom(BasicModel model){
        switch (from){
            case "New Arrivals":
                return new Intent(context, NewArrivalsWebView.class)
                        .putExtra("url",model.getUrlWeb());
            case "Men":
                return new Intent(context, MenWebView.class)
                        .putExtra("url",model.getUrlWeb());
            case "Women":
                return new Intent(context, WomenWebView.class)
                        .putExtra("url",model.getUrlWeb());
            case "Kids":
                return new Intent(context, KidsWebView.class)
                        .putExtra("url",model.getUrlWeb());
            case "Collections":
                return new Intent(context, CollectionWebView.class)
                        .putExtra("url",model.getUrlWeb());
            case  "Sports":
                return new Intent(context, SportWebView.class)
                        .putExtra("url",model.getUrlWeb());
            default: return null;
        }
    }

}