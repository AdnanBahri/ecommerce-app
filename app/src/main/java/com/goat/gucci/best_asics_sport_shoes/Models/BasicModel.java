package com.goat.gucci.best_asics_sport_shoes.Models;

public class BasicModel {

    private String title;
    private String url;
    private String urlWeb;

    public BasicModel() {
    }

    public BasicModel(String title, String url, String urlWeb) {
        this.title = title;
        this.url = url;
        this.urlWeb = urlWeb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlWeb() {
        return urlWeb;
    }

    public void setUrlWeb(String urlWeb) {
        this.urlWeb = urlWeb;
    }
}
