package com.goat.gucci.best_asics_sport_shoes.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.goat.gucci.best_asics_sport_shoes.Adapters.ViewPagerAdapter;
import com.goat.gucci.best_asics_sport_shoes.Fragments.Kids.KidsShoes;
import com.goat.gucci.best_asics_sport_shoes.Fragments.Men.MenAccessories;
import com.goat.gucci.best_asics_sport_shoes.Fragments.Men.MenClothes;
import com.goat.gucci.best_asics_sport_shoes.Fragments.Men.MenShoes;
import com.goat.gucci.best_asics_sport_shoes.Fragments.Women.WomenAccessories;
import com.goat.gucci.best_asics_sport_shoes.Fragments.Women.WomenClothes;
import com.goat.gucci.best_asics_sport_shoes.Fragments.Women.WomenShoes;
import com.goat.gucci.best_asics_sport_shoes.R;

public class CategorieContentActivity extends AppCompatActivity {

    private String from;

    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie_content);

        from = getIntent().getStringExtra("from");

        viewPager = (ViewPager) findViewById(R.id.categorie_view_pager);
        tab = (TabLayout) findViewById(R.id.categorie_tab);

        setUpViewPager();
        viewPager.setAdapter(adapter);
        tab.setupWithViewPager(viewPager);
    }

    private void setUpViewPager() {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        switch (from){
            case "Women":
                womenViewPager();
                break;
            case "Men":
                menViewPager();
                break;
            case "Kids":
                kidsViewPager();
                break;
            case "FITNESS":
                fitnessViewPager();
                break;
            case "PADEL":
                padelViewPager();
                break;
            case "RUNNING":
                runViewPager();
                break;
            case "TRAIL":
                trailViewPager();
                break;
            case "VOLLEYBALL":
                volleyViewPager();
                break;
        }
    }

    private void volleyViewPager() {
    }

    private void trailViewPager() {
    }

    private void runViewPager() {
    }

    private void padelViewPager() {
    }

    private void fitnessViewPager() {
//        adapter.addFragment();
    }

    private void womenViewPager() {
        adapter.addFragment(new WomenClothes(),"Clothes");
        adapter.addFragment(new WomenShoes(),"Shoes");
        adapter.addFragment(new WomenAccessories(),"Accessories");

    }

    private void menViewPager() {
        adapter.addFragment(new MenClothes(),"Clothes");
        adapter.addFragment(new MenShoes(),"Shoes");
        adapter.addFragment(new MenAccessories(),"Accessories");
    }

    private void kidsViewPager() {
        adapter.addFragment(new KidsShoes(),"Shoes");
    }
}
