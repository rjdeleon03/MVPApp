package com.rjdeleon.mvp_app.Models;

public class DNCAListItem {

    private String brgyName;
    private String areaName;
    private String date;
    private String imageUrl;
    private String downloadUrl;

    public DNCAListItem(String brgyName, String areaName, String date) {
        this.brgyName = brgyName;
        this.areaName = areaName;
        this.date = date;
    }

    public String getBrgyName() {
        return brgyName;
    }

    public String getAreaName() {
        return areaName;
    }

    public String getDate() {
        return date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}
