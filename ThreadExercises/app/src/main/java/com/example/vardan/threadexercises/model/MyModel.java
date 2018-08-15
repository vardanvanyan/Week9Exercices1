package com.example.vardan.threadexercises.model;

public class MyModel {
    private String text;
    private String imageUrl;
    private boolean imgDownload;

    public MyModel(String text, String imageUrl, boolean imgDownload) {
        this.text = text;
        this.imageUrl = imageUrl;
        this.imgDownload = imgDownload;
    }

    public boolean isImgDownload() {
        return imgDownload;
    }

    public void setImgDownload(boolean imgDownload) {
        this.imgDownload = imgDownload;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
