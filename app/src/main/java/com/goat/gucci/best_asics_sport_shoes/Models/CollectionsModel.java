package com.goat.gucci.best_asics_sport_shoes.Models;

public class CollectionsModel {

    private String title;
    private String img;

    public CollectionsModel() {
    }

    public CollectionsModel(String title, String img) {
        this.title = title;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
