package com.cpu.quikdata.Models;

import java.util.ArrayList;
import java.util.List;

public class CaseStories {

    private List<String> images;

    public CaseStories(List<String> images) {
        this.images = images;
    }

    public CaseStories() {
        this(new ArrayList<String>());
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
