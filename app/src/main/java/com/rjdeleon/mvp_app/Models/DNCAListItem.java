package com.rjdeleon.mvp_app.Models;

public class DNCAListItem {

    private int id;
    private FormInfo info;

    public DNCAListItem(int id, FormInfo info) {
        this.id = id;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public FormInfo getFormInfo() {
        return info;
    }
}
