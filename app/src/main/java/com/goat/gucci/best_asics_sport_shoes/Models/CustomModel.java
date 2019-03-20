package com.goat.gucci.best_asics_sport_shoes.Models;

public class CustomModel {

    private String title;
    private String header;
    private String leftTitle;
    private String leftUrl;
    private String leftUrlWeb;
    private String rightTitle;
    private String rightUrl;
    private String rightUrlWeb;

    public CustomModel() {
    }

    public CustomModel(String title, String header, String leftTitle, String leftUrl, String leftUrlWeb,
                       String rightTitle, String rightUrl, String rightUrlWeb) {
        this.title = title;
        this.header = header;
        this.leftTitle = leftTitle;
        this.leftUrl = leftUrl;
        this.leftUrlWeb = leftUrlWeb;
        this.rightTitle = rightTitle;
        this.rightUrl = rightUrl;
        this.rightUrlWeb = rightUrlWeb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getLeftTitle() {
        return leftTitle;
    }

    public void setLeftTitle(String leftTitle) {
        this.leftTitle = leftTitle;
    }

    public String getLeftUrl() {
        return leftUrl;
    }

    public void setLeftUrl(String leftUrl) {
        this.leftUrl = leftUrl;
    }

    public String getLeftUrlWeb() {
        return leftUrlWeb;
    }

    public void setLeftUrlWeb(String leftUrlWeb) {
        this.leftUrlWeb = leftUrlWeb;
    }

    public String getRightTitle() {
        return rightTitle;
    }

    public void setRightTitle(String rightTitle) {
        this.rightTitle = rightTitle;
    }

    public String getRightUrl() {
        return rightUrl;
    }

    public void setRightUrl(String rightUrl) {
        this.rightUrl = rightUrl;
    }

    public String getRightUrlWeb() {
        return rightUrlWeb;
    }

    public void setRightUrlWeb(String rightUrlWeb) {
        this.rightUrlWeb = rightUrlWeb;
    }
}
