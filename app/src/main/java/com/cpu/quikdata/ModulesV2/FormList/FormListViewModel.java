package com.cpu.quikdata.ModulesV2.FormList;

import android.support.annotation.Nullable;

import com.cpu.quikdata.ModelsV2.Form.Form;

import java.lang.ref.WeakReference;

import io.realm.Realm;
import io.realm.RealmResults;

public class FormListViewModel implements IFormListDataManager {

    @Nullable
    private WeakReference<IFormListActivity> mFormListActivity;

    private RealmResults<Form> mForms = null;


    /**
     * Constructor
     */
    public FormListViewModel() {

    }

    /**
     * Sets the form list activity interface
     * @param iFormListActivity
     */
    public void setFormListActivity(IFormListActivity iFormListActivity) {
        mFormListActivity = new WeakReference<>(iFormListActivity);
    }

    /**
     * Handles navigation when add button is pressed
     */
    public void navigateOnAddButtonPressed() {
        if (mFormListActivity.get() != null) {
            mFormListActivity.get().onAddButtonPressed();
        }
    }

    /**
     * Handles navigation when settings button is pressed
     */
    public void navigateOnSettingsButtonPressed() {
        if (mFormListActivity.get() != null) {
            mFormListActivity.get().onSettingsButtonPressed();
        }
    }

    /**
     * Gets all forms
     * @return
     */
    public RealmResults<Form> getAllForms() {
        if (mForms == null) {
            Realm realm = Realm.getDefaultInstance();
            mForms = realm.where(Form.class).findAll();
//            realm.close();
        }
        return mForms;
    }

    @Override
    public Form getFormAtIndex(int index) {
        return mForms.get(index);
    }
}
