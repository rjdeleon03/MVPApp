package com.cpu.quikdata.ModelsV2.Form.CaseStories;

import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class CaseStories extends RealmObject implements IFieldHolder {

    @Required
    @PrimaryKey
    private String id;

    private RealmList<String> imagePaths;
    private String storiesText;

    public CaseStories() {
        setupFields();
    }

    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public RealmList<String> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(RealmList<String> imagePaths) {
        this.imagePaths = imagePaths;
    }

    public String getStoriesText() {
        return storiesText;
    }

    public void setStoriesText(String storiesText) {
        this.storiesText = storiesText;
    }

    @Override
    public void setupFields() {
        if (imagePaths == null) {
            imagePaths = new RealmList<>();
        }
        if (storiesText == null) {
            storiesText = "";
        }
    }

    @Override
    public void deleteData() {
        imagePaths.deleteAllFromRealm();
        deleteFromRealm();
    }

}
